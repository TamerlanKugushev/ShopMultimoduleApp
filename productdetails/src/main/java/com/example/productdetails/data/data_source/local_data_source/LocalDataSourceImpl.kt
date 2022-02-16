package com.example.productdetails.data.data_source.local_data_source

import com.example.productdetails.data.model.local.ListProductDetailsDto
import com.example.productdetails.data.model.local.ProductDetailsDto

class LocalDataSourceImpl(private val mapPhones: ListProductDetailsDto) :
    LocalDataSource<ProductDetailsDto> {
    override suspend fun getData(id: String): ProductDetailsDto? = mapPhones.mapProductDetails[id]

    override suspend fun addData(id: String, data: ProductDetailsDto) {
        mapPhones.mapProductDetails[id] = data
    }
}