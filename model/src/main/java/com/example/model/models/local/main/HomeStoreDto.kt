package com.example.model.models.local.main

import com.example.model.models.local.ILocalData

data class HomeStoreDto(
    val id: Int?,
    val isNew: Boolean?,
    val title: String?,
    val subtitle: String?,
    val picture: String?
) : ILocalData