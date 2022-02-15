package com.example.mainscreen.domain.usecase

import com.example.mainscreen.data.model.local.MainDto

interface MainScreenUseCase {

    suspend fun getMain(): MainDto
}