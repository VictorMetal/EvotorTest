package com.example.evotortest.model.delivery

data class PaymentInfo(
    val isCache: Boolean,
    val defermentPeriod: Int,
    val isCacheless: Boolean,
    val isDefermentPayment: Boolean
)