package com.example.shopmultimoduleapp.di

import com.example.data.image_loader.GlideImageLoader
import com.example.data.image_loader.ImageLoader
import org.koin.dsl.module


val imageModule = module {
    single<ImageLoader> { GlideImageLoader() }
}