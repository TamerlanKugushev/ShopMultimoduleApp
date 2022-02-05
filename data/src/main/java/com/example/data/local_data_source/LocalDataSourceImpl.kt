package com.example.data.local_data_source

import com.example.model.models.local.productdetails.ListProductDetailsDto
import com.example.model.models.local.productdetails.ProductDetailsDto

class LocalDataSourceImpl(private val mapPhones: ListProductDetailsDto) :
    LocalDataSource<ProductDetailsDto> {
    override suspend fun getData(id: String): ProductDetailsDto? = mapPhones.mapProductDetails[id]

    override suspend fun addData(id: String, data: ProductDetailsDto) {
        mapPhones.mapProductDetails[id] = data
    }
}