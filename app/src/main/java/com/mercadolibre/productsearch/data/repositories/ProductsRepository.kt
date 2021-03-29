package com.mercadolibre.productsearch.data.repositories

import com.mercadolibre.productsearch.data.Result
import com.mercadolibre.productsearch.data.local.dao.ProductDaoHelper
import com.mercadolibre.productsearch.data.services.MercadoLibreService
import com.mercadolibre.productsearch.domain.entities.Product

class ProductsRepository(private val service: MercadoLibreService, private val productDaoHelper: ProductDaoHelper) {

    fun requestProductsByString(inputSearch: String): Result<List<Product>> {
        return service.getProductsByString(inputSearch)
    }

    fun getFavoritesProducts() = productDaoHelper.getFavorites()

    fun insertFavorite(product: Product) {
        productDaoHelper.insertProduct(product)
    }
}
