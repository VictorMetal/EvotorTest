package com.example.evotortest.model.delivery

data class DeliveryInfo(
    val nearestDeliveryDate: String,
    val deliveryDays: DeliveryDays,
    val deliveryPeriod: DeliveryPeriod,
    val minOrderCost: Int,
    val deliveryPrice: Int,
    val paymentInfo: PaymentInfo?
)