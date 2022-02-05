package com.example.model.models.responce.main

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.example.model.models.responce.IResponseData
import kotlinx.parcelize.Parcelize

@Parcelize
data class HomeStoreResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("is_new") val isNew: Boolean,
    @SerializedName("title") val title: String,
    @SerializedName("subtitle") val subtitle: String,
    @SerializedName("picture") val picture: String
) : Parcelable, IResponseData