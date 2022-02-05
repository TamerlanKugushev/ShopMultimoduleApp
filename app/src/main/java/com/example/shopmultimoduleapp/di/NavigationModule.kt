package com.example.shopmultimoduleapp.di

import com.github.terrakok.cicerone.Cicerone
import com.example.mainscreen.presentation.navigation.MainScreenNavigator
import com.example.mycart.presentation.navigation.MyCartNavigator
import com.example.productdetails.presentation.navigation.ProductDetailsNavigator
import com.example.splashscreen.navigation.SplashNavigator
import com.example.shopmultimoduleapp.navigation.Screens
import com.example.shopmultimoduleapp.navigation.*
import org.koin.dsl.module

val ciceroneModule = module {

    val cicerone = Cicerone.create()

    factory { cicerone.router }

    factory { cicerone.getNavigatorHolder() }

    single { Screens() }
}
val navigationModule = module {

    factory<ProductDetailsNavigator> { ProductDetailsNavigatorImpl(get(), get()) }
    factory<MyCartNavigator> { MyCartNavigatorImpl(get(), get()) }
    factory<MainScreenNavigator> { MainScreenNavigatorImpl(get(), get()) }
    factory<MainNavigator> { MainNavigatorImpl(get(), get()) }
    factory<SplashNavigator> { SplashNavigatorImpl(get(), get()) }
}