package com.example.mainscreen.domain.usecase

import com.example.model.models.local.main.MainDto

interface MainUseCase {

    suspend fun getMain(): MainDto
}