package com.example.evotortest.model.delivery

import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("delivery_prepaid") val deliveryPrepaid: Float
)