package com.example.mycart.data.model.remote

import android.os.Parcelable
import com.example.model.models.responce.IResponseData
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class ResponseBasket(
    @SerializedName("image") val images: String?,
    @SerializedName("title") val title: String?,
    @SerializedName("price") val price: Int?
) : Parcelable, IResponseData