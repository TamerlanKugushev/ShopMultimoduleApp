package com.example.mycart.data.model.local

import com.example.model.models.local.ILocalData

data class Cart(
    val id: String?,
    val basket: List<Basket>?,
    val total: Int?,
    val delivery: String?
) : ILocalData