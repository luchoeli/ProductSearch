package com.mercadolibre.productsearch.domain.entities

import com.mercadolibre.productsearch.presentation.base.StringUtils.EMPTY_STRING

data class Product(
    val id: String,
    val title: String,
    val image: String? = EMPTY_STRING
)
