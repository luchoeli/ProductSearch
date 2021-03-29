package com.mercadolibre.productsearch.domain.entities

import android.os.Parcelable
import androidx.room.Entity
import com.mercadolibre.productsearch.presentation.base.StringUtils.EMPTY_STRING
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductAddressEntity(
    val state_id: String? = EMPTY_STRING,
    val city_id: String? = EMPTY_STRING,
    val state_name: String? = EMPTY_STRING,
    val city_name: String? = EMPTY_STRING
) : Parcelable
