package com.example.evotortest.model.delivery

import com.google.gson.annotations.SerializedName

data class DeliveryDays(
    val monday: Boolean = false,
    @SerializedName("monday_time") val mondayTime: MondayTime?,
    val tuesday: Boolean = false,
    @SerializedName("tuesday_time") val tuesdayTime: TuesdayTime?,
    val wednesday: Boolean = false,
    @SerializedName("wednesday_time") val wednesdayTime: WednesdayTime?,
    val thursday: Boolean = false,
    @SerializedName("thursday_time") val thursdayTime: ThursdayTime?,
    val friday: Boolean = false,
    @SerializedName("friday_time") val fridayTime: FridayTime?,
    val saturday: Boolean = false,
    @SerializedName("saturday_time") val saturdayTime: SaturdayTime?,
    val sunday: Boolean = false,
    @SerializedName("sunday_time") val sundayTime: SundayTime?
)