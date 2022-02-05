package com.example.mycart.presentation.view_model

import com.example.core.view_model.BaseViewModel
import com.example.mycart.data.model.local.Cart
import com.example.mycart.domain.MyCartUseCase
import com.example.mycart.presentation.navigation.MyCartNavigator
import com.example.model.state.Result

class MyCartViewModel(
    private val useCase: MyCartUseCase,
    private val navigator: MyCartNavigator
) :
    BaseViewModel<Cart>() {

    fun getData() = runAsync {
        _liveData.postValue(Result.Success(useCase.getCart()))
    }

    fun onBackPressed() {
        navigator.onBackPressed()
    }
}