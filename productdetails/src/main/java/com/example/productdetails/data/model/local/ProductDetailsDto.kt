package com.example.productdetails.data.model.local

import com.example.model.models.local.ILocalData

data class ProductDetailsDto(
    val id: String,
    val images: List<String>,
    val isFavorites: Boolean,
    val title: String,
    val rating: Double,
    val CPU: String,
    val camera: String,
    val ssd: String,
    val sd: String,
    val color: List<String>,
    val capacity: List<String>,
    val price: Int
) : ILocalData