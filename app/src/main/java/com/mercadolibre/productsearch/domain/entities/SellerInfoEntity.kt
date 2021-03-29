package com.mercadolibre.productsearch.domain.entities

import android.os.Parcelable
import com.mercadolibre.productsearch.presentation.base.StringUtils
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SellerInfoEntity(
    val id: Long,
    val link: String,
    val logo: String? = StringUtils.EMPTY_STRING,
    val total: Int,
    val canceled: Int,
    val completed: Int
) : Parcelable
