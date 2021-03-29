package com.mercadolibre.productsearch.data.services.response

import com.mercadolibre.productsearch.presentation.base.StringUtils.EMPTY_STRING

class ProductAddressResponse(
    val state_id: String? = EMPTY_STRING,
    val city_id: String? = EMPTY_STRING,
    val state_name: String? = EMPTY_STRING,
    val city_name: String? = EMPTY_STRING
)
