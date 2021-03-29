package com.mercadolibre.productsearch.data.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MercadoLibreRequestGenerator {
    private val httpClient = OkHttpClient.Builder().build()

    private val builder = Retrofit.Builder()
        .baseUrl(MERCADO_LIBRE_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())

    fun <S> createService(serviceClass: Class<S>): S = builder.client(httpClient).build().create(serviceClass)

    companion object {
        private const val MERCADO_LIBRE_BASE_URL = "https://api.mercadolibre.com/"
    }
}
