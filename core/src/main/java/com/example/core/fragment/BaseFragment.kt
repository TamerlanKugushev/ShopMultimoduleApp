package com.example.core.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.core.view_model.BaseViewModel
import com.example.model.models.local.ILocalData
import com.example.model.state.Result

abstract class BaseFragment<VB : ViewBinding, T : ILocalData, VM : BaseViewModel<T>>(layout: Int) :
    Fragment(layout) {

    protected abstract val viewBinding: VB?
    protected abstract val viewModel: VM

    private fun provideData(state: Result<T>) {
        when (state) {
            is Result.Error -> provideError(state.error)
            is Result.Loading -> showLoading()
            is Result.Success -> provideSuccess(state.data)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.liveData.observe(viewLifecycleOwner) {
            provideData(it)
        }
    }

    protected abstract fun provideSuccess(data: T)

    protected open fun showLoading() {}

    protected open fun provideError(error: Throwable) {
        error.message?.let { showToast(it) }
    }

    private fun showToast(message: String) {
        Toast.makeText(this.context, message, Toast.LENGTH_LONG).show()
    }
}