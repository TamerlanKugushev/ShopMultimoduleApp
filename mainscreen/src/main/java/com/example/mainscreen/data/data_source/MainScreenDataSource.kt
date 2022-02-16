package com.example.mainscreen.data.data_source

import com.example.mainscreen.data.model.local.MainDto
import com.example.mainscreen.data.model.remote.MainResponse

interface MainScreenDataSource {

    suspend fun getRemoteMain(): List<MainResponse>

    suspend fun getLocalMain(): MainDto

    suspend fun insertMain(mainDto: MainDto)

}