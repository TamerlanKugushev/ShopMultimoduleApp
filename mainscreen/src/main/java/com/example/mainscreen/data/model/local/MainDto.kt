package com.example.mainscreen.data.model.local

import com.example.model.models.local.ILocalData

data class MainDto(
    val id: String?,
    val homeStoreDto: List<HomeStoreDto>?,
    val bestSellerDto: List<BestSellerDto>?
) : ILocalData