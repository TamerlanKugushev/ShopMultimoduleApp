package com.example.mycart.data.model.remote

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.example.model.models.responce.IResponseData
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResponseCart(
    @SerializedName("_id") val id: String?,
    @SerializedName("basket") val basket: List<ResponseBasket>?,
    @SerializedName("total") val total: Int?,
    @SerializedName("Delivery") val delivery: String?
) : Parcelable, IResponseData