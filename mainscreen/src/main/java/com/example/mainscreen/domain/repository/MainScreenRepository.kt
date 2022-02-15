package com.example.mainscreen.domain.repository

import com.example.mainscreen.data.model.local.MainDto

interface MainScreenRepository {

    suspend fun getMain(): MainDto

}