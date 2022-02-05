package com.example.mycart.data

import com.example.mycart.data.model.remote.ResponseCart
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface MyCartService {

    @GET("cart")
    fun getMyCartAsync(): Deferred<List<ResponseCart>>
}