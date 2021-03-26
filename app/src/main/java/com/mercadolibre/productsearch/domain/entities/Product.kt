package com.mercadolibre.productsearch.domain.entities

import android.os.Parcelable
import com.mercadolibre.productsearch.presentation.base.StringUtils.EMPTY_STRING
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Product(
    val id: String,
    val title: String,
    val price: Double,
    val image: String? = EMPTY_STRING,
    val address: ProductAddressEntity?,
    val acceptsMercadopago: Boolean? = false,
    val sellerInfo: SellerInfoEntity
): Parcelable
