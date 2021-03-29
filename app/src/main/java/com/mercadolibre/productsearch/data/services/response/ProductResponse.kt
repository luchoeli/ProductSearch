package com.mercadolibre.productsearch.data.services.response

import com.mercadolibre.productsearch.presentation.base.StringUtils.EMPTY_STRING

data class ProductResponse(
    val id: String,
    val title: String,
    val price: Double? = 0.0,
    val currency_id: String? = EMPTY_STRING,
    val thumbnail: String? = EMPTY_STRING,
    val permalink: String? = EMPTY_STRING,
    val accepts_mercadopago: Boolean? = false,
    val seller: ProductSellerInfoResponse? = null,
    val address: ProductAddressResponse? = null
)
