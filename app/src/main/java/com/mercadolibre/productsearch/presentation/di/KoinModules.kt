package com.mercadolibre.productsearch.presentation.di

import androidx.room.Room
import com.mercadolibre.productsearch.data.local.AppDatabase
import com.mercadolibre.productsearch.data.local.AppDatabase.Companion.DATABASE_NAME
import com.mercadolibre.productsearch.data.local.dao.ProductDaoHelper
import com.mercadolibre.productsearch.data.local.dao.RoomMapper
import com.mercadolibre.productsearch.data.repositories.ProductsRepository
import com.mercadolibre.productsearch.data.services.MercadoLibreService
import com.mercadolibre.productsearch.presentation.main.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val serviceModule = module {
    single { MercadoLibreService() }
}

val databaseModule = module {
    single { Room.databaseBuilder(get(), AppDatabase::class.java, DATABASE_NAME).build() }
    single { ProductDaoHelper(get()) }
    single { get<AppDatabase>().productDao() }
}

val repositoryModule = module {
    single { ProductsRepository(get(), get()) }
}

val viewModelModule = module {
    viewModel { SearchViewModel(get()) }
}

