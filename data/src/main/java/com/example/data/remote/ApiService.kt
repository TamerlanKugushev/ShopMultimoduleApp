package com.example.data.remote

import com.example.model.models.responce.main.MainResponse
import com.example.model.models.responce.productdetails.ProductDetailsResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {
    @GET("home")
    fun getMainAsync(): Deferred<List<MainResponse>>

    @GET("detail")
    fun getProductDetailsAsync(): Deferred<List<ProductDetailsResponse>>
}