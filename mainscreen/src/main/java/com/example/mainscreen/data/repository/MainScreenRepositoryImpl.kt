package com.example.mainscreen.data.repository

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.mainscreen.data.data_source.MainScreenDataSource
import com.example.mainscreen.data.model.local.BestSellerDto
import com.example.mainscreen.data.model.local.HomeStoreDto
import com.example.mainscreen.data.model.local.MainDto
import com.example.mainscreen.data.model.remote.BestSellerResponse
import com.example.mainscreen.data.model.remote.HomeStoreResponse
import com.example.mainscreen.data.model.remote.MainResponse
import com.example.mainscreen.domain.repository.MainScreenRepository

class MainScreenRepositoryImpl(
    private val dataSource: MainScreenDataSource,
    private val context: Context
) :
    MainScreenRepository {

    override suspend fun getMain(): MainDto {
        return if (hasInternetConnection()) {
            val entities = mapToMain(dataSource.getRemoteMain())
            dataSource.insertMain(entities)
            entities
        } else {
            dataSource.getLocalMain()
        }


//        val responseMain = dataSource.getRemoteMain()
//        return mapToMain(responseMain)
    }

    private fun mapToMain(response: List<MainResponse>): MainDto {
        val responseMain = response[0]
        val homeStore = mapToListHomeStore(responseMain.homeStoreResponse)
        val bestSeller = mapToListBestSeller(responseMain.bestSellerResponse)
        return MainDto(
            id = responseMain.id,
            homeStoreDto = homeStore,
            bestSellerDto = bestSeller
        )
    }

    private fun mapToListBestSeller(rBestSeller: List<BestSellerResponse>): List<BestSellerDto> =
        rBestSeller.map { responseBestSeller ->
            BestSellerDto(
                id = responseBestSeller.id,
                isFavorites = responseBestSeller.isFavorites,
                title = responseBestSeller.title,
                priceWithoutDiscount = responseBestSeller.discountPrice,
                discountPrice = responseBestSeller.priceWithoutDiscount,
                picture = responseBestSeller.picture
            )
        }

    private fun mapToListHomeStore(rHomeStore: List<HomeStoreResponse>): List<HomeStoreDto> =
        rHomeStore.map { responseHomeStore ->
            HomeStoreDto(
                id = responseHomeStore.id,
                isNew = responseHomeStore.isNew,
                title = responseHomeStore.title,
                subtitle = responseHomeStore.subtitle,
                picture = responseHomeStore.picture
            )
        }

    @SuppressLint("NewApi")
    private fun hasInternetConnection(): Boolean {
        val connectivityManager = context.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        val activityNetwork = connectivityManager.activeNetwork ?: return false
        val capabilities =
            connectivityManager.getNetworkCapabilities(activityNetwork) ?: return false
        return when {
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
            else -> false
        }
    }
}