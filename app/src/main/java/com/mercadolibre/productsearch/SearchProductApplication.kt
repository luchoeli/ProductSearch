package com.mercadolibre.productsearch

import android.app.Application
import com.mercadolibre.productsearch.presentation.di.databaseModule
import com.mercadolibre.productsearch.presentation.di.repositoryModule
import com.mercadolibre.productsearch.presentation.di.serviceModule
import com.mercadolibre.productsearch.presentation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SearchProductApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SearchProductApplication)
            modules(
                listOf(
                    viewModelModule,
                    serviceModule,
                    repositoryModule,
                    databaseModule
                )
            )
        }
    }
}
