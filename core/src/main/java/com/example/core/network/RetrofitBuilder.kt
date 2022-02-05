package com.example.core.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.example.data.remote.BaseInterceptor
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient.Builder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitBuilder {

    companion object {
        private const val BASE_URL = "https://shopapi-0575.restdb.io/rest/"
        private val client =
            Builder()
                .addInterceptor(BaseInterceptor())
                .addInterceptor(
                    HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY)
                ).build()

        fun <T> create(api: Class<T>): T {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(client)
                .build()
                .create(api)
        }
    }

}