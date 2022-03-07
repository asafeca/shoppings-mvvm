package com.laas.shoppingsmvvm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.laas.shoppingsmvvm.data.local.dao.ProductInfoDao
import com.laas.shoppingsmvvm.data.local.entity.ProductInfoEntity
import com.laas.shoppingsmvvm.data.util.Converter

@Database(entities = [ProductInfoEntity::class], version = 1)
@TypeConverters(Converter::class)
abstract class ProductInfoDatabase : RoomDatabase() {
    abstract val dao: ProductInfoDao
}