package com.example.evotortest.model

import com.example.evotortest.model.delivery.DeliveryData
import com.google.gson.annotations.SerializedName

data class Offers(
    @SerializedName("data") val deliveries: List<DeliveryData>,
    val count: Int
)