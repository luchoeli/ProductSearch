package com.mercadolibre.productsearch.data.services.response

data class ProductResponse(
    val id: String,
    val title: String,
    val price: Double,
    val thumbnail: String,
    val permalink: String
)
