package com.example.mainscreen.data.data_source

import com.example.mainscreen.data.model.remote.MainResponse

interface MainScreenDataSource {

    suspend fun getMain(): List<MainResponse>


}