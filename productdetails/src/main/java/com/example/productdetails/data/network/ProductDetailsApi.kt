package com.example.productdetails.data.network

import com.example.productdetails.data.model.remote.ProductDetailsResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ProductDetailsApi {

    @GET("detail")
    fun getProductDetailsAsync(): Deferred<List<ProductDetailsResponse>>
}