package com.example.mainscreen.data.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.model.models.local.ILocalData

@Entity(tableName = "best_sellers_tables")
data class BestSellerDto(
    @PrimaryKey
    val id: Int?,
    @ColumnInfo(name = "isFavorites")
    val isFavorites: Boolean?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "priceWithoutDiscount")
    val priceWithoutDiscount: Int?,
    @ColumnInfo(name = "discountPrice")
    val discountPrice: Int?,
    @ColumnInfo(name = "picture")
    val picture: String?
) : ILocalData

