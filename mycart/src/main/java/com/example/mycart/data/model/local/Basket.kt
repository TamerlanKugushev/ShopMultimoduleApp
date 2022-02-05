package com.example.mycart.data.model.local

import com.example.model.models.local.ILocalData

data class Basket(
    val id: Int,
    val images: String?,
    val title: String?,
    val price: Int?
) : ILocalData