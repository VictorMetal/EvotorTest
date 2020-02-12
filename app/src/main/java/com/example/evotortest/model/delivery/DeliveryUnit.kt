package com.example.evotortest.model.delivery

import com.google.gson.annotations.SerializedName

data class DeliveryUnit(
    @SerializedName("mult") val multiplier: Int,        // Это было не обязательно
    @SerializedName("um") val unitMeasuring: String     // но я попытался сделать осмысленные переменные
)