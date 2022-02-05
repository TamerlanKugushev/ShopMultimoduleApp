package com.example.productdetails.domain.usecase

import com.example.model.models.local.productdetails.ProductDetailsDto
import com.example.productdetails.domain.repository.ProductDetailsRepository

class ProductDetailsUseCaseImpl(private val repository: ProductDetailsRepository) :
    ProductDetailsUseCase {

    override suspend fun getProductDetails(id: String): ProductDetailsDto? =
        repository.getProductDetails(id)
}