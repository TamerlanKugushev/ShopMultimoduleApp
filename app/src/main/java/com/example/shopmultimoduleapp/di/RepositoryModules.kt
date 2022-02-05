package com.example.shopmultimoduleapp.di

import com.example.mainscreen.domain.usecase.MainUseCase
import com.example.mainscreen.domain.usecase.MainUseCaseImpl
import com.example.productdetails.domain.usecase.ProductDetailsUseCase
import com.example.productdetails.domain.usecase.ProductDetailsUseCaseImpl
import com.example.model.models.local.productdetails.ListProductDetailsDto
import com.example.model.models.local.productdetails.ProductDetailsDto
import com.example.data.remote_data_source.RemoteDataSource
import com.example.data.remote_data_source.RemoteDataSourceImpl
import com.example.data.image_loader.GlideImageLoader
import com.example.data.image_loader.ImageLoader
import com.example.data.local_data_source.LocalDataSource
import com.example.data.local_data_source.LocalDataSourceImpl
import com.example.mainscreen.domain.repository.MainRepository
import com.example.mainscreen.data.MainRepositoryImpl
import com.example.productdetails.domain.repository.ProductDetailsRepository
import com.example.productdetails.data.ProductDetailsRepositoryImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }
    single<LocalDataSource<ProductDetailsDto>> { LocalDataSourceImpl(get()) }
}

val repositoryModule = module {
    single { ListProductDetailsDto() }
    single<MainRepository> { MainRepositoryImpl(get()) }
    single<ProductDetailsRepository> { ProductDetailsRepositoryImpl(get(), get()) }
}

val interactorModule = module {
    single<MainUseCase> { MainUseCaseImpl(get()) }
    single<ProductDetailsUseCase> { ProductDetailsUseCaseImpl(get()) }
}

val imageModule = module {
    single<ImageLoader> { GlideImageLoader() }
}