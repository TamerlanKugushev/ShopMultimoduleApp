package com.example.productdetails.domain.usecase

import com.example.productdetails.data.model.local.ProductDetailsDto
import com.example.productdetails.domain.repository.ProductDetailsRepository

class ProductDetailsUseCaseImpl(private val repository: ProductDetailsRepository) :
    ProductDetailsUseCase {

    override suspend fun getProductDetails(id: String): ProductDetailsDto? =
        repository.getProductDetails(id)
}