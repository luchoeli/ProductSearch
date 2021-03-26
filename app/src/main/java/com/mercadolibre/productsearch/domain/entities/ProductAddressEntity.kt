package com.mercadolibre.productsearch.domain.entities

import com.mercadolibre.productsearch.presentation.base.StringUtils.EMPTY_STRING

class ProductAddressEntity(
    val state_name: String? = EMPTY_STRING,
    val city_name: String? = EMPTY_STRING
)
