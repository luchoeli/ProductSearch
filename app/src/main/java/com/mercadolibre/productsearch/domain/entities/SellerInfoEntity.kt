package com.mercadolibre.productsearch.domain.entities

import com.mercadolibre.productsearch.presentation.base.StringUtils

data class SellerInfoEntity(
    val link: String,
    val logo: String? = StringUtils.EMPTY_STRING,
    val total: Int,
    val canceled: Int,
    val completed: Int
)
