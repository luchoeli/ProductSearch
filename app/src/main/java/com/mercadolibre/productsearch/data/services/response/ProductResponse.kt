package com.mercadolibre.productsearch.data.services.response

data class ProductResponse(
    val id: String,
    val title: String,
    val price: Double,
    val currency_id: String,
    val thumbnail: String,
    val permalink: String,
    val accepts_mercadopago: Boolean? = false,
    val seller: ProductSellerInfoResponse,
    val address: ProductAddressResponse
)
