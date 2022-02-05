package com.example.splashscreen.view_model

import androidx.lifecycle.ViewModel
import com.example.splashscreen.navigation.SplashNavigator
import kotlinx.coroutines.*

class SplashViewModel(private val navigation: SplashNavigator) : ViewModel() {

    private val viewModelCoroutineScope =
        CoroutineScope(
            Dispatchers.Main
                    + SupervisorJob()
        )

    fun cancelJob() {
        viewModelCoroutineScope.coroutineContext.cancelChildren()
    }

    fun toMainScreen(timeMillis: Long) {
        viewModelCoroutineScope.launch {
            delay(timeMillis)
            navigation.navigateToMainScreen()
        }
    }
}