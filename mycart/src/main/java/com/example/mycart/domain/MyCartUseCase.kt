package com.example.mycart.domain

import com.example.mycart.data.model.local.Cart

interface MyCartUseCase {

    suspend fun getCart(): Cart
}