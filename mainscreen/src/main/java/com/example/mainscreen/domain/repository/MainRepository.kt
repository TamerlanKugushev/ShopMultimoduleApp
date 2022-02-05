package com.example.mainscreen.domain.repository

import com.example.model.models.local.main.MainDto

interface MainRepository {
    suspend fun getMain(): MainDto
}