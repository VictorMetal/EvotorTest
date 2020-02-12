package com.example.evotortest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.evotortest.model.Product
import com.example.evotortest.utils.Constants
import com.example.evotortest.utils.Utils.toImageUriArray
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ProductsAdapter.OnItemClickListener {

    private lateinit var viewModel: MainViewModel
    private lateinit var productsAdapter: ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setupRecyclerView()
        setupSwipeRefreshLayout()
        observeLiveData()
        viewModel.getProducts()
    }

    private fun setupRecyclerView() {
        productsAdapter = ProductsAdapter(this)
        rvProducts.adapter = productsAdapter
        rvProducts.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
    }

    private fun setupSwipeRefreshLayout() {
        srlMain.isRefreshing = true
        srlMain.setOnRefreshListener {
            viewModel.getProducts()
        }
        srlMain.setColorSchemeResources(
            R.color.colorPrimaryDark,
            R.color.colorPrimary,
            R.color.colorAccent
        )
    }

    private fun observeLiveData() {
        viewModel.products.observe(this, Observer {
            srlMain.isRefreshing = false
            productsAdapter.updateProducts(it)
        })

        viewModel.product.observe(this, Observer {
            openProduct(it)
        })

        viewModel.error.observe(this, Observer {
            srlMain.isRefreshing = false
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onProductClick(position: Int) {
        viewModel.onItemClick(position)
    }

    private fun openProduct(product: Product) {
        val intent = Intent(this, ProductActivity::class.java).apply {
            putExtra(Constants.BRAND, product.brandName)
            putExtra(Constants.NAME, product.name)
            putExtra(Constants.IMAGES, product.imagesUUID.toImageUriArray())
            putExtra(Constants.PRICE, product.price)
            putExtra(
                Constants.NEAREST_DELIVERY_DATE,
                product.offers.deliveries.firstOrNull()?.deliveryInfo?.nearestDeliveryDate
            )
            putExtra(Constants.BOXING, product.attributes.boxing)
            product.attributes.weight?.let { weight ->
                putExtra(Constants.WEIGHT_VALUE, weight.value)
                putExtra(Constants.WEIGHT_UNIT, weight.unitMeasuring)
            }
        }
        startActivity(intent)
    }
}
