package com.example.productdetails.data.data_source.remote_data_source

import com.example.productdetails.data.model.remote.ProductDetailsResponse
import com.example.productdetails.data.network.ProductDetailsApi

class ProductDetailsRemoteDataSourceImpl(private val api: ProductDetailsApi) : ProductDetailsRemoteDataSource {

    override suspend fun getProductDetails(): List<ProductDetailsResponse> =
        api.getProductDetailsAsync().await()
}