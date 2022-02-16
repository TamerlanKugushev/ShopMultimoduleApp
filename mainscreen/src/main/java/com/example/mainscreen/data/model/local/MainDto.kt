package com.example.mainscreen.data.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.model.models.local.ILocalData

@Entity(tableName = "main_tables")
data class MainDto(
    @PrimaryKey
    val id: String?,
    @ColumnInfo(name = "homeStoreDto")
    val homeStoreDto: List<HomeStoreDto>,
    @ColumnInfo(name = "bestSellerDto")
    val bestSellerDto: List<BestSellerDto>
) : ILocalData