package com.example.mycart.data

import com.example.mycart.data.model.local.Basket
import com.example.mycart.data.model.local.Cart
import com.example.mycart.data.model.remote.ResponseBasket
import com.example.mycart.data.model.remote.ResponseCart
import com.example.mycart.domain.MyCartRepository

class MyCartRepositoryImpl(private val dataSource: MyCartRemoteDataSource) :
    MyCartRepository {

    override suspend fun getCart(): Cart {
        val listResponseCart = dataSource.getMyCart()
        return mapToCart(listResponseCart)
    }

    private fun mapToCart(response: List<ResponseCart>): Cart {
        val responseCart = response[0]
        val basket = responseCart.basket?.let { mapToListBasket(it) }
        return Cart(
            id = responseCart.id,
            basket = basket,
            total = responseCart.total,
            delivery = responseCart.delivery
        )
    }

    private fun mapToListBasket(rBasket: List<ResponseBasket>): List<Basket> =
        rBasket.map { responseBasket ->
            Basket(
                id = rBasket.indexOf(responseBasket),
                images = responseBasket.images,
                title = responseBasket.title,
                price = responseBasket.price
            )
        }
}