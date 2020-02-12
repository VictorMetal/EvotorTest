package com.example.evotortest.model.delivery

import com.google.gson.annotations.SerializedName

data class DeliveryData (
    val deliveryInfo: DeliveryInfo,
    val price: Price,
    @SerializedName("supplier_product_id" )val supplierProductId: String,
    @SerializedName("supplier_display_name" )val supplierDisplayName: String,
    val minOrderCost: Int,
    val uuid: String,
    @SerializedName("supplier_id") val supplierId: String,
    val deliveryUnit: DeliveryUnit
)