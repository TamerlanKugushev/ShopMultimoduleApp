package com.example.productdetails.domain.usecase

import com.example.model.models.local.productdetails.ProductDetailsDto

interface ProductDetailsUseCase {

    suspend fun getProductDetails(id: String): ProductDetailsDto?
}