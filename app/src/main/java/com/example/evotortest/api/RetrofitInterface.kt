package com.example.evotortest.api

import com.example.evotortest.model.Envelope
import com.example.evotortest.model.Product
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("5db966c630000075005ee2aa")
    suspend fun getProducts(): Envelope<List<Product>>
}