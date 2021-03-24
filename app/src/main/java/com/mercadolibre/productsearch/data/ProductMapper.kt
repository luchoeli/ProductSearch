package com.mercadolibre.productsearch.data

import com.mercadolibre.productsearch.data.services.response.ProductResponse
import com.mercadolibre.productsearch.domain.entities.Products

class ProductMapper : BaseMapperRepository<ProductResponse, Products> {
    override fun transform(type: ProductResponse): Products =
        with(type) {
            Products(id, title)
        }

    override fun transformList(list: List<ProductResponse>): List<Products> =
        list.map { productResponse ->
            transform(productResponse)
        }
}
