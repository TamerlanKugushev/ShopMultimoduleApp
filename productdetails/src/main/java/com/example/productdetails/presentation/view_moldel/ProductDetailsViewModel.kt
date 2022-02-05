package com.example.productdetails.presentation.view_moldel

import com.example.core.view_model.BaseViewModel
import com.example.model.models.local.productdetails.ProductDetailsDto
import com.example.model.state.Result
import com.example.productdetails.presentation.navigation.ProductDetailsNavigator
import com.example.productdetails.domain.usecase.ProductDetailsUseCase

class ProductDetailsViewModel(
    private val useCase: ProductDetailsUseCase,
    private val navigator: ProductDetailsNavigator
) :
    BaseViewModel<ProductDetailsDto>() {

    fun getData(id: String) = runAsync {
        val data = useCase.getProductDetails(id)
        data?.let { _liveData.postValue(Result.Success(it)) }
    }

    fun onBackPressed() {
        navigator.onBackPressed()
    }

    fun toMyCartScreen() {
        navigator.navigateToMyCartFragment()
    }
}