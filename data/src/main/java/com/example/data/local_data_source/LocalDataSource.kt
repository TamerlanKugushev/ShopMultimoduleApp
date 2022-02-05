package com.example.data.local_data_source

import com.example.model.models.local.ILocalData

interface LocalDataSource<T: ILocalData> {
    suspend fun getData(id: String): T?
    suspend fun addData(id: String, data: T)
}