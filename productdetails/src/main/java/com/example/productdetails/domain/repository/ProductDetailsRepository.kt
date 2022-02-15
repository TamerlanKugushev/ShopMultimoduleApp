package com.example.productdetails.domain.repository

import com.example.productdetails.data.model.local.ProductDetailsDto

interface ProductDetailsRepository {
    suspend fun getProductDetails(id: String): ProductDetailsDto?
}