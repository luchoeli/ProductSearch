package com.mercadolibre.productsearch.data

import com.mercadolibre.productsearch.data.services.response.ProductAddressResponse
import com.mercadolibre.productsearch.data.services.response.ProductResponse
import com.mercadolibre.productsearch.data.services.response.ProductSellerInfoResponse
import com.mercadolibre.productsearch.domain.entities.Product
import com.mercadolibre.productsearch.domain.entities.ProductAddressEntity
import com.mercadolibre.productsearch.domain.entities.SellerInfoEntity

class ProductMapper : BaseMapperRepository<ProductResponse, Product> {
    override fun transform(type: ProductResponse): Product =
        with(type) {
            Product(
                id = id,
                title = title,
                price = price,
                image = thumbnail,
                permalink = permalink,
                address = address?.let { transformAddress(it) },
                acceptsMercadopago = accepts_mercadopago,
                sellerInfo = seller?.let { transformSellerInfo(it) }
            )
        }

    override fun transformList(list: List<ProductResponse>): List<Product> =
        list.map { productResponse ->
            transform(productResponse)
        }

    private fun transformAddress(response: ProductAddressResponse): ProductAddressEntity =
        with(response) {
            ProductAddressEntity(
                state_name = state_name,
                city_name = city_name,
                city_id = city_id,
                state_id = state_id
            )
        }

    private fun transformSellerInfo(response: ProductSellerInfoResponse): SellerInfoEntity =
        with(response) {
            SellerInfoEntity(
                id = id,
                link = permalink,
                logo = car_dealer_logo,
                total = seller_reputation.transactions.total,
                canceled = seller_reputation.transactions.canceled,
                completed = seller_reputation.transactions.completed
            )
        }
}
