package com.example.evotortest.model

data class Envelope<T>(
    val result: Int,
    val data: T
)