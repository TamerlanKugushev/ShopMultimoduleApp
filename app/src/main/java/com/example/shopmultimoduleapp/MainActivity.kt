package com.example.shopmultimoduleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.shopmultimoduleapp.view_model.MainViewModel
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val navigatorHolder: NavigatorHolder by inject()
    private var navigator: AppNavigator? = null
    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        initNavigation()

        if (supportFragmentManager.fragments.isEmpty()) {
            viewModel.toSplashScreen()
        }
    }

    private fun initNavigation() {
        navigator = AppNavigator(this, R.id.fragmentContainer)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigator?.let {
            navigatorHolder.setNavigator(it)
        }
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}