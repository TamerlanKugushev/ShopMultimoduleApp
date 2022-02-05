package com.example.mycart.data

import com.example.mycart.data.model.remote.ResponseCart

interface MyCartRemoteDataSource {

    suspend fun getMyCart(): List<ResponseCart>
}