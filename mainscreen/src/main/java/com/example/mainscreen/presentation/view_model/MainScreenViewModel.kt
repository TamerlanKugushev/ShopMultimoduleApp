package com.example.mainscreen.presentation.view_model

import com.example.core.view_model.BaseViewModel
import com.example.mainscreen.domain.usecase.MainUseCase
import com.example.mainscreen.presentation.navigation.MainScreenNavigator
import com.example.model.models.local.main.MainDto
import com.example.model.state.Result

class MainScreenViewModel(
    private val useCase: MainUseCase,
    private val navigator: MainScreenNavigator
) :
    BaseViewModel<MainDto>() {

    fun getData() = runAsync {
        showLoading()
        _liveData.postValue(Result.Success(useCase.getMain()))
    }

    fun toProductDetailsScreen(id: String){
        navigator.navigateToProductDetailsScreen(id)
    }
}