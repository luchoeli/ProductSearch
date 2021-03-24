package com.mercadolibre.productsearch.data.services.api

import com.mercadolibre.productsearch.data.services.response.MainProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MercadoLibreAPI {
    @GET("/sites/MLA/search")
    fun getProductsRequest(@Query("q") inputSearch: String) : Call<MainProductResponse>
}
