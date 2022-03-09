package com.laas.shoppingsmvvm.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.laas.shoppingsmvvm.data.local.dao.ProductInfoDao
import com.laas.shoppingsmvvm.data.local.entity.ProductInfoEntity
import com.laas.shoppingsmvvm.data.util.Converter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [ProductInfoEntity::class], version = 1)
@TypeConverters(Converter::class)
abstract class ProductInfoDatabase : RoomDatabase() {
    abstract val dao: ProductInfoDao

    companion object {

        @Volatile
        private var INSTANCE: ProductInfoDatabase? = null
        fun getDatabase(context: Context, scope: CoroutineScope): ProductInfoDatabase {

            return INSTANCE
                ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        ProductInfoDatabase::class.java,
                        "shoppingsdb"

                    )
                        .addCallback(productDatabaseCallback(scope))
                        .addMigrations(DbMigrations.MIGRATION_1_2)
                        .build()

                    INSTANCE = instance

                    instance
                }


        }

    }

    private class productDatabaseCallback(private val scope: CoroutineScope) :
        RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE?.let {
                val database = it
                scope.launch {
                    populateDatabase(database.dao)
                }
            }
        }


        private fun populateDatabase(dao: ProductInfoDao) {

        }

    }
}