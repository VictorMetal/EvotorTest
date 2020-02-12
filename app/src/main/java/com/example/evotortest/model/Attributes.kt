package com.example.evotortest.model

import com.google.gson.annotations.SerializedName

data class Attributes (
    @SerializedName("bonus_program") val bonusProgram: Boolean,
    val boxing: String,
    val weight: Weight?
)