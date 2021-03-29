package com.mercadolibre.productsearch.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mercadolibre.productsearch.data.local.ProductRoom

@Dao
interface ProductDao {
    @Query("SELECT * FROM product")
    fun getAll(): LiveData<List<ProductRoom>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: ProductRoom)
}
