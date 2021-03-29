package com.mercadolibre.productsearch.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mercadolibre.productsearch.presentation.base.NumberUtils.ZERO_DOUBLE
import com.mercadolibre.productsearch.presentation.base.StringUtils.EMPTY_STRING

@Entity(tableName = "product")
data class ProductRoom(
    @PrimaryKey
    val id: String = EMPTY_STRING,
    val title: String = EMPTY_STRING,
    val price: Double? = ZERO_DOUBLE,
    val image: String? = EMPTY_STRING,
    val permalink: String? = EMPTY_STRING,
    val acceptsMercadopago: Boolean? = false
)
