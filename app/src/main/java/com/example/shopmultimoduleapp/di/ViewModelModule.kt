package com.example.shopmultimoduleapp.di

import com.example.mainscreen.presentation.view_model.MainScreenViewModel
import com.example.productdetails.presentation.view_moldel.ProductDetailsViewModel
import com.example.splashscreen.view_model.SplashViewModel
import com.example.shopmultimoduleapp.view_model.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainScreenViewModel(get(), get()) }
    viewModel { ProductDetailsViewModel(get(), get()) }
    viewModel { MainViewModel(get()) }
    viewModel { SplashViewModel(get()) }
}