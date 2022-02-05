package com.example.model.models.local.main

import com.example.model.models.local.ILocalData

data class BestSellerDto(
    val id: Int?,
    val isFavorites: Boolean?,
    val title: String?,
    val priceWithoutDiscount: Int?,
    val discountPrice: Int?,
    val picture: String?
) : ILocalData

