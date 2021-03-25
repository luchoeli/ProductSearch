package com.mercadolibre.productsearch.data

import com.mercadolibre.productsearch.data.services.response.ProductResponse
import com.mercadolibre.productsearch.domain.entities.Product

class ProductMapper : BaseMapperRepository<ProductResponse, Product> {
    override fun transform(type: ProductResponse): Product =
        with(type) {
            Product(
                id = id,
                title = title,
                image = thumbnail
            )
        }

    override fun transformList(list: List<ProductResponse>): List<Product> =
        list.map { productResponse ->
            transform(productResponse)
        }
}
