package com.example.mainscreen.presentation.navigation

import com.example.core.navigation.BaseNavigator

interface MainScreenNavigator : BaseNavigator {

    fun navigateToProductDetailsScreen(id: String)
}
