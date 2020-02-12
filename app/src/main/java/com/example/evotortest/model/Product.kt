package com.example.evotortest.model

import com.example.evotortest.model.delivery.DeliveryUnit
import com.google.gson.annotations.SerializedName

data class Product(
    val offers: Offers,
    @SerializedName("images") val imagesUUID: List<String> = listOf(),
    @SerializedName("brand_name") val brandName: String,
    val uuid: String,
    val price: Float,
    @SerializedName("has_case_sale") val hasCaseSale: Boolean,
    val name: String,
    @SerializedName("seo_name") val seoName: String,
    val attributes: Attributes,
    @SerializedName("category_ids") val categoryIds: List<Int>,
    val brand: Int,
    val favorite: Boolean,
    val deliveryUnit: DeliveryUnit
)