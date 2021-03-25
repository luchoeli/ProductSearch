package com.mercadolibre.productsearch.data.services

import com.mercadolibre.productsearch.data.ProductMapper
import com.mercadolibre.productsearch.data.Result
import com.mercadolibre.productsearch.data.services.api.MercadoLibreAPI
import com.mercadolibre.productsearch.domain.entities.Product
import java.io.IOException

class MercadoLibreService {
    private val api = MercadoLibreRequestGenerator()
    private val mapper = ProductMapper()

    fun getProductsByString(searchInput: String): Result<List<Product>> {
        try {
            val apiCall = api.createService(MercadoLibreAPI::class.java).getProductsRequest(searchInput)
            val response = apiCall.execute()
            if (response.isSuccessful && response.body() != null) {
                response.body()?.let { mainResponse ->
                    mapper.transformList(mainResponse.results)
                }?.let { return Result.Success(it) }
            }
        } catch (e: Exception) {
            return Result.Failure(e)
        }
        return Result.Failure(IOException())
    }
}
