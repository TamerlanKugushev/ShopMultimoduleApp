package com.example.mycart.di

import com.example.core.network.RetrofitBuilder
import com.example.mycart.data.MyCartRemoteDataSource
import com.example.mycart.data.MyCartRemoteDataSourceImpl
import com.example.mycart.data.MyCartRepositoryImpl
import com.example.mycart.data.MyCartService
import com.example.mycart.domain.MyCartUseCase
import com.example.mycart.domain.MyCartUseCaseImpl
import com.example.mycart.domain.MyCartRepository
import com.example.mycart.presentation.view_model.MyCartViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myCartModule = module {
    single { RetrofitBuilder.create(MyCartService::class.java) }
    factory<MyCartRemoteDataSource> { MyCartRemoteDataSourceImpl(get()) }
    factory<MyCartRepository> { MyCartRepositoryImpl(get()) }
    factory<MyCartUseCase> { MyCartUseCaseImpl(get()) }

    viewModel { MyCartViewModel(get(), get()) }
}