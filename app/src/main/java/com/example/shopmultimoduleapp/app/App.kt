package com.example.shopmultimoduleapp.app

import android.app.Application
import com.example.mainscreen.di.mainScreenModule
import com.example.mycart.di.myCartModule
import com.example.productdetails.di.productDetailsScreenModule
import com.example.shopmultimoduleapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                viewModelModule,
                ciceroneModule,
                navigationModule,
                imageModule,
                myCartModule,
                mainScreenModule,
                productDetailsScreenModule
            )
        }
    }
}