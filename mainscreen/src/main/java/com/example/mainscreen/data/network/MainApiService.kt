package com.example.mainscreen.data.network

import com.example.mainscreen.data.model.remote.MainResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface MainApiService {

    @GET("home")
    fun getMainAsync(): Deferred<List<MainResponse>>
}