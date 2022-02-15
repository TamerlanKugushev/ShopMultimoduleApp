package com.example.productdetails.data.data_source.local_data_source

import com.example.productdetails.data.model.local.ProductDetailsDto

class LocalDataSourceImpl(private val mapPhones: com.example.productdetails.data.model.local.ListProductDetailsDto) :
    LocalDataSource<ProductDetailsDto> {
    override suspend fun getData(id: String): com.example.productdetails.data.model.local.ProductDetailsDto? = mapPhones.mapProductDetails[id]

    override suspend fun addData(id: String, data: com.example.productdetails.data.model.local.ProductDetailsDto) {
        mapPhones.mapProductDetails[id] = data
    }
}