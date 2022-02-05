package com.example.data.remote_data_source

import com.example.model.models.responce.main.MainResponse
import com.example.model.models.responce.productdetails.ProductDetailsResponse


interface RemoteDataSource {
    suspend fun getMain(): List<MainResponse>
    suspend fun getProductDetails(): List<ProductDetailsResponse>
}