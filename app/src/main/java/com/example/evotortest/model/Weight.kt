package com.example.evotortest.model

import com.google.gson.annotations.SerializedName

data class Weight(
    @SerializedName("val") val value: Double,           // Это было не обязательно
    @SerializedName("um") val unitMeasuring: String     // но я попытался сделать осмысленные переменные
)