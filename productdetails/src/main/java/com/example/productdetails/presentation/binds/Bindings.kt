package com.example.productdetails.presentation.binds

import android.view.View
import com.example.core.listener.BaseItemListener
import com.example.data.image_loader.ImageLoader
import com.example.productdetails.databinding.ItemPhotoPhoneBinding

fun bindProductDetails(
    view: View,
    data: String,
    listener: BaseItemListener,
    imageLoader: ImageLoader
) {
    val binding = ItemPhotoPhoneBinding.bind(view)
    imageLoader.loadImage(data, binding.ivPhoneItemPhotoPhone)
}