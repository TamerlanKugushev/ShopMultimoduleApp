package com.example.shopmultimoduleapp.di

import com.example.core.network.RetrofitBuilder
import com.example.data.remote.ApiService
import org.koin.dsl.module

val retrofitModule = module {
    single { RetrofitBuilder.create(ApiService::class.java) }
}
