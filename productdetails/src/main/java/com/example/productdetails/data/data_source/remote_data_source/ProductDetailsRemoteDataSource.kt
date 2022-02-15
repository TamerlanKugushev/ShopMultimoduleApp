package com.example.productdetails.data.data_source.remote_data_source

import com.example.productdetails.data.model.remote.ProductDetailsResponse

interface ProductDetailsRemoteDataSource {

    suspend fun getProductDetails(): List<ProductDetailsResponse>
}