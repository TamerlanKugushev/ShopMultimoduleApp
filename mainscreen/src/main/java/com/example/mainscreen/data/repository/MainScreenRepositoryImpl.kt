package com.example.mainscreen.data.repository

import com.example.mainscreen.data.model.local.BestSellerDto
import com.example.mainscreen.data.model.local.HomeStoreDto
import com.example.mainscreen.data.model.local.MainDto
import com.example.mainscreen.data.model.remote.BestSellerResponse
import com.example.mainscreen.data.model.remote.HomeStoreResponse
import com.example.mainscreen.data.model.remote.MainResponse
import com.example.mainscreen.data.data_source.MainScreenDataSource
import com.example.mainscreen.domain.repository.MainScreenRepository

class MainScreenRepositoryImpl(
    private val dataSource: MainScreenDataSource,
) :
    MainScreenRepository {

    override suspend fun getMain(): MainDto {
        val responseMain = dataSource.getMain()
        return mapToMain(responseMain)
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
}