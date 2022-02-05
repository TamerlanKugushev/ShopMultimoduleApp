package com.example.productdetails.domain.repository

import com.example.model.models.local.productdetails.ProductDetailsDto

interface ProductDetailsRepository {
    suspend fun getProductDetails(id: String): ProductDetailsDto?
}