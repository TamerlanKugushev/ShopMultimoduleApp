package com.example.mycart.presentation.adapter.dif_util

import androidx.recyclerview.widget.DiffUtil
import com.example.mycart.data.model.local.Basket

class BasketDifUtil : DiffUtil.ItemCallback<Basket>() {

    override fun areItemsTheSame(oldItem: Basket, newItem: Basket): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Basket, newItem: Basket): Boolean {
        return oldItem == newItem
    }
}