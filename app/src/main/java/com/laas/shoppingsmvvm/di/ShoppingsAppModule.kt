package com.laas.shoppingsmvvm.di

import android.app.Application
import com.laas.shoppingsmvvm.data.local.ProductInfoDatabase
import com.laas.shoppingsmvvm.data.remote.CommonApi
import com.laas.shoppingsmvvm.data.remote.ProductInfoService
import com.laas.shoppingsmvvm.data.repository.ProductInfoRepositoryImpl
import com.laas.shoppingsmvvm.domain.usecase.GetProductsInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


class ShoppingsApp: Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())
    val shoppingsDataBase by lazy { ProductInfoDatabase.getDatabase(this, applicationScope)}


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

}