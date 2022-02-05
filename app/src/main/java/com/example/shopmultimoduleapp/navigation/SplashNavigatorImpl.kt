package com.example.shopmultimoduleapp.navigation

import com.github.terrakok.cicerone.Router
import com.example.splashscreen.navigation.SplashNavigator

class SplashNavigatorImpl(private val router: Router, private val screens: Screens) :
    SplashNavigator {

    override fun navigateToMainScreen() {
        router.replaceScreen(screens.mainScreen())
    }

    override fun onBackPressed() {
        router.exit()
    }
}