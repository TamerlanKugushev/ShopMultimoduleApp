package com.example.mycart.domain

import com.example.mycart.data.model.local.Cart
import com.example.mycart.domain.MyCartRepository
import com.example.mycart.domain.MyCartUseCase

class MyCartUseCaseImpl(private val repository: MyCartRepository) :
    MyCartUseCase {

    override suspend fun getCart(): Cart = repository.getCart()
}