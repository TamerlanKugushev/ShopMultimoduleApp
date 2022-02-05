package com.example.shopmultimoduleapp.navigation

import com.github.terrakok.cicerone.Router
import com.example.productdetails.presentation.navigation.ProductDetailsNavigator

class ProductDetailsNavigatorImpl(
    private val screens: Screens,
    private val router: Router) : ProductDetailsNavigator {

   override fun onBackPressed() {
        router.exit()
    }

    override fun navigateToMyCartFragment() {
        router.navigateTo(screens.myCartScreen())
    }
}