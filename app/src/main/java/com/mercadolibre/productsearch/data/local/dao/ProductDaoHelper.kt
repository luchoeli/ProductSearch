package com.mercadolibre.productsearch.data.local.dao

import androidx.lifecycle.map
import com.mercadolibre.productsearch.domain.entities.Product

class ProductDaoHelper(private val productDao: ProductDao) {

    private val mapper: RoomMapper = RoomMapper()
    fun getFavorites() = productDao.getAll().map {
        mapper.transformListToEntityList(it)
    }

    fun insertProduct(product: Product) {
        productDao.insertProduct(mapper.transform(product))
    }
}
