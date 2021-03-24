package com.mercadolibre.productsearch.presentation.di

import com.mercadolibre.productsearch.data.repositories.ProductsRepository
import com.mercadolibre.productsearch.data.services.MercadoLibreService
import com.mercadolibre.productsearch.presentation.main.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
val serviceModule = module {
    single { MercadoLibreService() }
}

val repositoryModule = module {
    single { ProductsRepository(get()) }
}

val viewModelModule = module {
    viewModel { SearchViewModel(get()) }
}

