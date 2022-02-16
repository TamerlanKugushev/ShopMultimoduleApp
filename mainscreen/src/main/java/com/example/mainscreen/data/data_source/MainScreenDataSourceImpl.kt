package com.example.mainscreen.data.data_source

import com.example.mainscreen.data.db.MainScreenDao
import com.example.mainscreen.data.model.local.MainDto
import com.example.mainscreen.data.model.remote.MainResponse
import com.example.mainscreen.data.network.MainApiService

class MainScreenDataSourceImpl(
    private val api: MainApiService,
    private val mainScreenDao: MainScreenDao,
) : MainScreenDataSource {

    override suspend fun getRemoteMain(): List<MainResponse> = api.getMainAsync().await()

    override suspend fun getLocalMain(): MainDto {
        return mainScreenDao.readAllData()
    }

    override suspend fun insertMain(mainDto: MainDto) {
        mainScreenDao.insertMain(mainDto)
    }


}