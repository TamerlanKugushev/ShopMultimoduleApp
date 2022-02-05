package com.example.data.remote_data_source

import com.example.data.remote.ApiService
import com.example.model.models.responce.main.MainResponse
import com.example.model.models.responce.productdetails.ProductDetailsResponse

class RemoteDataSourceImpl(private val api: ApiService) :
    RemoteDataSource {
    override suspend fun getMain(): List<MainResponse> = api.getMainAsync().await()
    override suspend fun getProductDetails(): List<ProductDetailsResponse> =
        api.getProductDetailsAsync().await()
}