package com.example.model.models.responce.main

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.example.model.models.responce.IResponseData
import kotlinx.parcelize.Parcelize

@Parcelize
data class MainResponse(
    @SerializedName("_id") val id: String,
    @SerializedName("home_store") val homeStoreResponse: List<HomeStoreResponse>,
    @SerializedName("best_seller") val bestSellerResponse: List<BestSellerResponse>
) : Parcelable, IResponseData