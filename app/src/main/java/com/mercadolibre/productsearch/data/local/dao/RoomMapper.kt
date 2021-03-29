package com.mercadolibre.productsearch.data.local.dao

import com.mercadolibre.productsearch.data.BaseMapperRepository
import com.mercadolibre.productsearch.data.local.ProductRoom
import com.mercadolibre.productsearch.domain.entities.Product

class RoomMapper : BaseMapperRepository<Product, ProductRoom> {
    override fun transform(type: Product): ProductRoom =
        with(type) {
            ProductRoom(
                id = id,
                title = title,
                price = price,
                image = image,
                permalink = permalink
            )
        }

    override fun transformList(list: List<Product>): List<ProductRoom> =
        list.map { product -> transform(product) }

    fun transformRoomToEntity(productRoom: ProductRoom): Product =
        with(productRoom) {
            Product(
                id = id,
                title = title,
                price = price,
                image = image,
                permalink = permalink
            )
        }

    fun transformListToEntityList(listRoom: List<ProductRoom>): List<Product> =
        listRoom.map { productRoom ->
            transformRoomToEntity(productRoom)
        }
}
