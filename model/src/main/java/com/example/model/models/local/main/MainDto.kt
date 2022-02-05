package com.example.model.models.local.main

import com.example.model.models.local.ILocalData

data class MainDto(
    val id: String?,
    val homeStoreDto: List<HomeStoreDto>?,
    val bestSellerDto: List<BestSellerDto>?
) : ILocalData