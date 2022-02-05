package com.example.mainscreen.domain.usecase

import com.example.mainscreen.domain.repository.MainRepository
import com.example.model.models.local.main.MainDto

class MainUseCaseImpl(private val repository: MainRepository) : MainUseCase {

    override suspend fun getMain(): MainDto {
        return repository.getMain()
    }
}