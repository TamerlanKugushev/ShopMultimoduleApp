package com.example.productdetails.di

import com.example.core.network.RetrofitBuilder
import com.example.productdetails.data.data_source.local_data_source.LocalDataSource
import com.example.productdetails.data.data_source.local_data_source.LocalDataSourceImpl
import com.example.productdetails.data.model.local.ListProductDetailsDto
import com.example.productdetails.data.model.local.ProductDetailsDto
import com.example.productdetails.data.network.ProductDetailsApi
import com.example.productdetails.data.data_source.remote_data_source.ProductDetailsRemoteDataSource
import com.example.productdetails.data.data_source.remote_data_source.ProductDetailsRemoteDataSourceImpl
import com.example.productdetails.data.repository.ProductDetailsRepositoryImpl
import com.example.productdetails.domain.repository.ProductDetailsRepository
import com.example.productdetails.domain.usecase.ProductDetailsUseCase
import com.example.productdetails.domain.usecase.ProductDetailsUseCaseImpl
import com.example.productdetails.presentation.view_moldel.ProductDetailsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val productDetailsScreenModule = module {
    single { RetrofitBuilder.create(ProductDetailsApi::class.java) }
    factory<ProductDetailsRemoteDataSource> { ProductDetailsRemoteDataSourceImpl(get()) }
    factory<LocalDataSource<ProductDetailsDto>> { LocalDataSourceImpl(get()) }
    factory { ListProductDetailsDto() }
    factory<ProductDetailsRepository> { ProductDetailsRepositoryImpl(get(), get()) }
    factory<ProductDetailsUseCase> { ProductDetailsUseCaseImpl(get()) }

    viewModel { ProductDetailsViewModel(get(), get()) }
}