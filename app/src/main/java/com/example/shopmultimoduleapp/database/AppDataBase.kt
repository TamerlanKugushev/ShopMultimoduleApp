package com.example.shopmultimoduleapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mainscreen.data.db.MainScreenDao
import com.example.mainscreen.data.model.local.BestSellerDto
import com.example.mainscreen.data.model.local.HomeStoreDto
import com.example.mainscreen.data.model.local.MainDto

@Database(
    entities = [
        MainDto::class,
        BestSellerDto::class,
        HomeStoreDto::class
    ], version = 1, exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun mainScreenDao(): MainScreenDao
}