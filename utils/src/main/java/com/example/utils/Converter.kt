package com.example.utils

import java.lang.StringBuilder

fun parseIntToPriceForItemMyCart(price: Int): String = "$${price}.00"

fun convertIntToPriceForBestSeller(price: Int): String {
    val strPrise = StringBuilder(price.toString())
    val newPrice: String =
        when {
            price >= 100000 -> {
                strPrise.insert(3, ",")
                strPrise.toString()
            }
            price >= 10000 -> {
                strPrise.insert(2, ",")
                strPrise.toString()
            }
            price >= 1000 -> {
                strPrise.insert(1, ",")
                strPrise.toString()
            }
            else -> {
                price.toString()
            }
        }

    return "$$newPrice"
}

fun convertIntToPriceForProductDetails(price: Int): String = "${convertIntToPriceForBestSeller(price)}.00"

fun parseIntToPriceForMyCart(price: Int): String = "${convertIntToPriceForBestSeller(price)} us"