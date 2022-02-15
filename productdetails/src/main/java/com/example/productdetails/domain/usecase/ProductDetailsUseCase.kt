package com.example.productdetails.domain.usecase

import com.example.productdetails.data.model.local.ProductDetailsDto

interface ProductDetailsUseCase {

    suspend fun getProductDetails(id: String): ProductDetailsDto?
}