package com.example.shopmultimoduleapp.navigation

import com.github.terrakok.cicerone.Router
import com.example.mainscreen.presentation.navigation.MainScreenNavigator

class MainScreenNavigatorImpl(
    private val screens: Screens,
    private val router: Router
) : MainScreenNavigator {

    override fun navigateToProductDetailsScreen(id: String) {
        router.navigateTo(screens.productDetailsScreen(id))
    }

    override fun onBackPressed() {
        router.exit()
    }
}