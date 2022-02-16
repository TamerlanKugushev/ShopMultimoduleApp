package com.example.mainscreen.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mainscreen.data.model.local.BestSellerDto
import com.example.mainscreen.data.model.local.HomeStoreDto
import com.example.mainscreen.data.model.local.MainDto


@Dao
interface MainScreenDao {

    @Query("SELECT * FROM main_tables")
    fun readAllData(): MainDto

    @Query("SELECT * FROM home_stores_tables")
    fun getInsertHomeStores(): HomeStoreDto

    @Query("SELECT * FROM best_sellers_tables")
    fun getBestSeller(): BestSellerDto

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMain(mainDto: MainDto) {
        insertHomeStores(mainDto.homeStoreDto)
        insertBestSeller(mainDto.bestSellerDto)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHomeStores(homeStores: List<HomeStoreDto>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBestSeller(bestSellers: List<BestSellerDto>)


}