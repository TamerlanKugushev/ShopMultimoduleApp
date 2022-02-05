package com.example.shopmultimoduleapp.view_model

import androidx.lifecycle.ViewModel
import com.example.shopmultimoduleapp.navigation.MainNavigator

class MainViewModel(private val navigator: MainNavigator): ViewModel() {

    fun toSplashScreen(){
        navigator.navigateToSplashScreen()
    }
}