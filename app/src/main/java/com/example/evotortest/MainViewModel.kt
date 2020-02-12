package com.example.evotortest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evotortest.api.ApiService
import com.example.evotortest.model.Product
import com.hadilq.liveevent.LiveEvent
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _products: MutableLiveData<List<Product>> = MutableLiveData()
    val products: LiveData<List<Product>>
        get() = _products

    private val _product: LiveEvent<Product> = LiveEvent()
    val product: LiveData<Product>
        get() = _product

    private val _error: LiveEvent<String> = LiveEvent()
    val error: LiveData<String>
        get() = _error

    fun getProducts() {
        viewModelScope.launch {
            try {
                val result = ApiService.retrofit.getProducts()
                _products.postValue(result.data)
            } catch (throwable: Throwable) {
                _error.postValue(throwable.localizedMessage)
            }
        }
    }

    fun onItemClick(position: Int) {
        if (position < products.value?.size ?: 0) {
            products.value?.get(position)?.let {
                _product.value = it
            } ?: _error.postValue("Can't get product on position: $position")
        } else {
            _error.postValue("Can't get product on position: $position")
        }
    }
}