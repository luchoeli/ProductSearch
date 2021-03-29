package com.mercadolibre.productsearch.domain.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mercadolibre.productsearch.presentation.base.NumberUtils.ZERO_DOUBLE
import com.mercadolibre.productsearch.presentation.base.StringUtils.EMPTY_STRING
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "product")
data class Product(
    @PrimaryKey
    val id: String,
    val title: String,
    val price: Double? = ZERO_DOUBLE,
    val image: String? = EMPTY_STRING,
    val permalink: String? = EMPTY_STRING,
    val address: ProductAddressEntity? = null,
    val acceptsMercadopago: Boolean? = false,
    val sellerInfo: SellerInfoEntity? = null
): Parcelable
