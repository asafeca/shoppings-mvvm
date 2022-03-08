package com.laas.shoppingsmvvm.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.laas.shoppingsmvvm.data.local.entity.ProductInfoEntity

@Dao
interface ProductInfoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products: List<ProductInfoEntity>)

    @Query("SELECT * FROM productinfo")
    suspend fun getProductsInfo(): List<ProductInfoEntity>

    @Query("DELETE FROM productinfo WHERE id !=0")
    suspend fun deleteAllProducts()
}