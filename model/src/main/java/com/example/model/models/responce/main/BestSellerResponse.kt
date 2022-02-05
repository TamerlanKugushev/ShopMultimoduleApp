package com.example.model.models.responce.main

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.example.model.models.responce.IResponseData
import kotlinx.parcelize.Parcelize

@Parcelize
data class BestSellerResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("is_favorites") val isFavorites: Boolean,
    @SerializedName("title") val title: String,
    @SerializedName("price_without_discount") val priceWithoutDiscount: Int,
    @SerializedName("discount_price") val discountPrice: Int,
    @SerializedName("picture") val picture: String
) : Parcelable, IResponseData

