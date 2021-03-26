package com.mercadolibre.productsearch.domain.entities

import android.os.Parcelable
import com.mercadolibre.productsearch.presentation.base.StringUtils.EMPTY_STRING
import kotlinx.android.parcel.Parcelize

@Parcelize
class ProductAddressEntity(
    val state_name: String? = EMPTY_STRING,
    val city_name: String? = EMPTY_STRING
) : Parcelable
