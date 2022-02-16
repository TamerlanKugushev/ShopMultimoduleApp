package com.example.mainscreen.data.model.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.model.models.local.ILocalData

@Entity(tableName = "home_stores_tables")
data class HomeStoreDto(
    @PrimaryKey
    val id: Int?,
    @ColumnInfo(name = "isNew")
    val isNew: Boolean?,
    @ColumnInfo(name = "title")
    val title: String?,
    @ColumnInfo(name = "subtitle")
    val subtitle: String?,
    @ColumnInfo(name = "picture")
    val picture: String?
) : ILocalData