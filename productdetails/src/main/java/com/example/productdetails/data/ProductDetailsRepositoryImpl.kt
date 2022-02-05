package com.example.productdetails.data

import com.example.data.remote_data_source.RemoteDataSource
import com.example.data.local_data_source.LocalDataSource
import com.example.model.models.local.productdetails.ProductDetailsDto
import com.example.model.models.responce.productdetails.ProductDetailsResponse
import com.example.productdetails.domain.repository.ProductDetailsRepository

class ProductDetailsRepositoryImpl(
    private val dataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource<ProductDetailsDto>
) :
    ProductDetailsRepository {

    override suspend fun getProductDetails(id: String): ProductDetailsDto? {
        val listResponseProductDetails = dataSource.getProductDetails()
        val samsungGalaxyNote = mapToProductDetails(listResponseProductDetails)
        localDataSource.addData("111", samsungGalaxyNote)
        localDataSource.addData("3333", samsungGalaxyNote)

        return localDataSource.getData(id)
    }

    private fun mapToProductDetails(response: List<ProductDetailsResponse>): ProductDetailsDto {
        val responseProductDetails = response[0]
        return ProductDetailsDto(
            id = responseProductDetails.id,
            images = responseProductDetails.images,
            isFavorites = responseProductDetails.isFavorites,
            title = responseProductDetails.title,
            rating = responseProductDetails.rating,
            CPU = responseProductDetails.CPU,
            camera = responseProductDetails.camera,
            ssd = responseProductDetails.ssd,
            sd = responseProductDetails.sd,
            color = responseProductDetails.color,
            capacity = responseProductDetails.capacity,
            price = responseProductDetails.price
        )
    }
}