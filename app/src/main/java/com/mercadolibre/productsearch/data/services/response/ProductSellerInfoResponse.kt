package com.mercadolibre.productsearch.data.services.response

data class ProductSellerInfoResponse(
    val id: Long,
    val permalink: String,
    val car_dealer_logo: String,
    val seller_reputation: SellerReputation
)
