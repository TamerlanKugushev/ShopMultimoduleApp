package com.example.mycart.data

import com.example.mycart.data.model.remote.ResponseCart

class MyCartRemoteDataSourceImpl(private val api: MyCartService) : MyCartRemoteDataSource {

    override suspend fun getMyCart(): List<ResponseCart> = api.getMyCartAsync().await()
}