package com.example.model.state

import com.example.model.models.local.ILocalData

sealed class Result<out T : ILocalData> {
    data class Success<out T : ILocalData>(val data: T) : Result<T>()
    class Loading<out T : ILocalData>() : Result<T>()
    data class Error<out T : ILocalData>(val error: Throwable) : Result<T>()
}