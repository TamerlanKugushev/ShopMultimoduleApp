package com.example.shopmultimoduleapp.navigation

import com.github.terrakok.cicerone.Router
import com.example.mycart.presentation.navigation.MyCartNavigator

class MyCartNavigatorImpl(
    private val screens: Screens,
    private val router: Router
): MyCartNavigator {

    override fun onBackPressed() {
        router.exit()
    }
}