package com.example.mainscreen.data

import com.example.data.remote_data_source.RemoteDataSource
import com.example.mainscreen.domain.repository.MainRepository
import com.example.model.models.local.main.BestSellerDto
import com.example.model.models.local.main.HomeStoreDto
import com.example.model.models.local.main.MainDto
import com.example.model.models.responce.main.BestSellerResponse
import com.example.model.models.responce.main.HomeStoreResponse
import com.example.model.models.responce.main.MainResponse

class MainRepositoryImpl(private val dataSource: RemoteDataSource) :
    MainRepository {

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