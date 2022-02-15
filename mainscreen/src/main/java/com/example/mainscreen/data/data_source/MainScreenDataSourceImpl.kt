package com.example.mainscreen.data.data_source

import com.example.mainscreen.data.model.remote.MainResponse
import com.example.mainscreen.data.network.MainApiService

class MainScreenDataSourceImpl(
    private val api: MainApiService,
) : MainScreenDataSource {

    override suspend fun getMain(): List<MainResponse> = api.getMainAsync().await()
}