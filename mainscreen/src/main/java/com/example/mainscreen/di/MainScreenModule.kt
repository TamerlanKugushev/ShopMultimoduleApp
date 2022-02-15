package com.example.mainscreen.di

import com.example.core.network.RetrofitBuilder
import com.example.mainscreen.data.network.MainApiService
import com.example.mainscreen.data.data_source.MainScreenDataSource
import com.example.mainscreen.data.data_source.MainScreenDataSourceImpl
import com.example.mainscreen.data.repository.MainScreenRepositoryImpl
import com.example.mainscreen.domain.repository.MainScreenRepository
import com.example.mainscreen.domain.usecase.MainScreenUseCase
import com.example.mainscreen.domain.usecase.MainScreenUseCaseImpl
import com.example.mainscreen.presentation.view_model.MainScreenViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainScreenModule = module {
    single { RetrofitBuilder.create(MainApiService::class.java) }
    factory<MainScreenDataSource> { MainScreenDataSourceImpl(get()) }
    factory<MainScreenRepository> { MainScreenRepositoryImpl(get()) }
    factory<MainScreenUseCase> { MainScreenUseCaseImpl(get()) }

    viewModel { MainScreenViewModel(get(), get()) }
}