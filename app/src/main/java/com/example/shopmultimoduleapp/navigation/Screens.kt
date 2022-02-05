package com.example.shopmultimoduleapp.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.example.mainscreen.presentation.fragment.MainScreenFragment
import com.example.mycart.presentation.fragment.MyCartFragment
import com.example.feature_product_details.presentation.fragment.ProductDetailsFragment
import com.example.splashscreen.fragment.SplashFragment

class Screens {
    fun splashScreen() = FragmentScreen { SplashFragment() }
    fun mainScreen() = FragmentScreen { MainScreenFragment() }
    fun productDetailsScreen(id: String) = FragmentScreen { ProductDetailsFragment.newInstance(id) }
    fun myCartScreen() = FragmentScreen { MyCartFragment() }
}