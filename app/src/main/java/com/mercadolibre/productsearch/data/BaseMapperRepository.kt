package com.mercadolibre.productsearch.data

interface BaseMapperRepository<E, D> {
    fun transform(type: E): D
    fun transformList(list: List<E>): List<D>
}
