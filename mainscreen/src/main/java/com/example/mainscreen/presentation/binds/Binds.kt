package com.example.mainscreen.presentation.binds

import android.text.SpannableString
import android.text.Spanned
import android.text.style.StrikethroughSpan
import android.view.View
import com.example.core.listener.BaseItemListener
import com.example.data.image_loader.ImageLoader
import com.example.mainscreen.presentation.listener.BestSellerItemListener
import com.example.mainscreen.R
import com.example.mainscreen.databinding.ItemBestSellerBinding
import com.example.mainscreen.databinding.ItemHotSalesBinding
import com.example.mainscreen.data.model.local.BestSellerDto
import com.example.mainscreen.data.model.local.HomeStoreDto
import com.example.utils.convertIntToPriceForBestSeller

internal fun bindHotSales(
    view: View,
    data: HomeStoreDto,
    listener: BaseItemListener,
    imageLoader: ImageLoader
) {
    val binding = ItemHotSalesBinding.bind(view)
    val urlImage = data.picture
    val title = data.title
    val subtitle = data.subtitle
    val isNew = data.isNew ?: false
    with(binding) {
        urlImage?.let {
            imageLoader.loadImage(it, ivPhoneHotSales)
        }
        tvPhoneName.text = title
        tvPhoneDescription.text = subtitle
        if (!isNew) ivNew.visibility = View.INVISIBLE
    }

}

internal fun bindBestSeller(
    view: View,
    data: BestSellerDto,
    listener: BestSellerItemListener,
    imageLoader: ImageLoader
) {
    val binding: ItemBestSellerBinding = ItemBestSellerBinding.bind(view)
    val discountPrise = convertIntToPriceForBestSeller(data.discountPrice ?: 0)
    val priceWithoutDiscount = convertIntToPriceForBestSeller(data.priceWithoutDiscount ?: 0)
    val uri = data.picture
    val isFavorites = data.isFavorites ?: false
    val title = data.title

    val span = SpannableString(priceWithoutDiscount)
    span.setSpan(StrikethroughSpan(), 0, span.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    view.setOnClickListener {
        listener.itemListener(data.id.toString())
    }

    with(binding) {
        uri?.let { imageLoader.loadImage(it, ivPhoneBestSeller) }
        tvModelPhone.text = title
        tvDiscountPrice.text = discountPrise
        tvPriceWithoutDiscount.text = span
        if (isFavorites) ivLikeBestSeller.setImageResource(R.drawable.like)
    }
}