package com.example.mainscreen.data.model.local

import com.example.model.models.local.ILocalData

data class HomeStoreDto(
    val id: Int?,
    val isNew: Boolean?,
    val title: String?,
    val subtitle: String?,
    val picture: String?
) : ILocalData