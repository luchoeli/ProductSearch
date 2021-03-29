package com.mercadolibre.productsearch.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mercadolibre.productsearch.data.local.AppDatabase.Companion.DATABASE_VERSION
import com.mercadolibre.productsearch.data.local.dao.ProductDao

@Database(
    entities = [ProductRoom::class],
    version = DATABASE_VERSION
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        const val DATABASE_NAME = "search_product_db"
        const val DATABASE_VERSION = 1
    }
}
