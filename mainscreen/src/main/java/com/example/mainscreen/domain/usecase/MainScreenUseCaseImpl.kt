package com.example.mainscreen.domain.usecase

import com.example.mainscreen.domain.repository.MainScreenRepository
import com.example.mainscreen.data.model.local.MainDto

class MainScreenUseCaseImpl(private val repository: MainScreenRepository) : MainScreenUseCase {

    override suspend fun getMain(): MainDto {
        return repository.getMain()
    }
}