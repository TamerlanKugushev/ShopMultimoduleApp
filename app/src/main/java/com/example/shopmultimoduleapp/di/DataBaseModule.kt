package com.example.shopmultimoduleapp.di

import androidx.room.Room
import com.example.mainscreen.data.db.MainScreenDao
import com.example.shopmultimoduleapp.database.AppDataBase
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataBaseModule = module {

    single<AppDataBase> {
        Room.databaseBuilder(
            androidApplication(),
            AppDataBase::class.java, "store_database"
        ).build()
    }

    single<MainScreenDao>{
        get<AppDataBase>().mainScreenDao()
    }

}