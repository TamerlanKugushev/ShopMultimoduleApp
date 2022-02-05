package com.example.mycart.domain

import com.example.mycart.data.model.local.Cart

interface MyCartRepository {

    suspend fun getCart(): Cart
}