package com.example.core.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.model.models.local.ILocalData
import com.example.model.state.Result
import kotlinx.coroutines.*

abstract class BaseViewModel<T : ILocalData> : ViewModel() {

    protected val _liveData = MutableLiveData<Result<T>>()
    val liveData: LiveData<Result<T>> = _liveData

    private val viewModelCoroutineScope =
        CoroutineScope(
            Dispatchers.IO
                    + SupervisorJob()
                    + CoroutineExceptionHandler { _, error ->
                _liveData.postValue(Result.Error(error))
            }
        )

    fun cancelJob() {
        viewModelCoroutineScope.coroutineContext.cancelChildren()
    }

    protected fun runAsync(block: suspend () -> Unit) {
        viewModelCoroutineScope.launch {
            block()
        }
    }

    protected fun showLoading() {
        _liveData.postValue(Result.Loading())
    }

    override fun onCleared() {
        super.onCleared()
        cancelJob()
    }
}