package com.laas.shoppingsmvvm.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.laas.shoppingsmvvm.data.local.ProductInfoDatabase
import com.laas.shoppingsmvvm.data.remote.CommonApi
import com.laas.shoppingsmvvm.data.remote.ProductInfoService
import com.laas.shoppingsmvvm.data.repository.ProductInfoRepositoryImpl
import com.laas.shoppingsmvvm.data.util.Converter
import com.laas.shoppingsmvvm.data.util.GsonParser
import com.laas.shoppingsmvvm.domain.usecase.GetProductsInfo


class ShoppingsAppModule : Application() {

    val shoppingsDataBase = Room.databaseBuilder(
        Application(),
        ProductInfoDatabase::class.java,
        "shoppings_db"
    )
        .addTypeConverter(Converter(GsonParser(Gson())))
        .build()


    val getProductInfo by lazy {
        GetProductsInfo(
            ProductInfoRepositoryImpl(
                dao = shoppingsDataBase.dao,
                api = productinfoService
            )
        )

    }


    private val productinfoService by lazy {
        CommonApi.Create().create(ProductInfoService::class.java)
    }


    /*

    @Provides
    @Singleton
    fun provideGetProductsInfo(repository: ProductInfoRepository): GetProductsInfo {
        return GetProductsInfo(repository)
    }

    @Provides
    @Singleton
    fun provideProductInfoRepository(
        database: ProductInfoDatabase,
        api: ShoppingsApi
    ): ProductInfoRepository {
        val dao = database.dao
        return ProductInfoRepositoryImpl(dao, api)
    }

    @Provides
    @Singleton
    fun provideShoppingsDatabase(app: Application): ProductInfoDatabase {

        return Room.databaseBuilder(
            app,
            ProductInfoDatabase::class.java,
            "shoppings_db"
        )
            .addTypeConverter(Converter(GsonParser(Gson())))
            .build()

    }


    @Provides
    @Singleton
    fun providesShoppingsApi(): ShoppingsApi {
        return Retrofit.Builder()
            .baseUrl(ShoppingsApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ShoppingsApi::class.java)

    }

    */

}