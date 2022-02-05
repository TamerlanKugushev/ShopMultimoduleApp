package com.example.shopmultimoduleapp.navigation

import com.github.terrakok.cicerone.Router

class MainNavigatorImpl(private val screens: Screens, private val router: Router) : MainNavigator {

    override fun navigateToSplashScreen() {
        router.replaceScreen(screens.splashScreen())
    }

    override fun onBackPressed() {
        router.exit()
    }
}