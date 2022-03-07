package com.laas.shoppingsmvvm.di

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import com.laas.shoppingsmvvm.data.local.ProductInfoDatabase
import com.laas.shoppingsmvvm.data.remote.ShoppingsApi
import com.laas.shoppingsmvvm.data.repository.ProductInfoRepositoryImpl
import com.laas.shoppingsmvvm.data.util.Converter
import com.laas.shoppingsmvvm.data.util.GsonParser
import com.laas.shoppingsmvvm.domain.repository.ProductInfoRepository
import com.laas.shoppingsmvvm.domain.usecase.GetProductsInfo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ShoppingsAppModule {

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

}