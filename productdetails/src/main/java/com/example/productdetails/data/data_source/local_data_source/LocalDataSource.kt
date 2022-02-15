package com.example.productdetails.data.data_source.local_data_source

import com.example.model.models.local.ILocalData

interface LocalDataSource<T: ILocalData> {
    suspend fun getData(id: String): T?
    suspend fun addData(id: String, data: T)
}