package com.example.data.image_loader

import android.widget.ImageView

interface ImageLoader {
    fun loadImage(
        uri: String,
        view: ImageView,
    )
}