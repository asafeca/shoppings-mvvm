package com.laas.shoppingsmvvm.data.repository

import com.laas.shoppingsmvvm.core.util.Resource
import com.laas.shoppingsmvvm.data.local.dao.ProductInfoDao
import com.laas.shoppingsmvvm.data.remote.ProductInfoService
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel
import com.laas.shoppingsmvvm.domain.repository.ProductInfoRepository

import java.io.IOException

class ProductInfoRepositoryImpl(
    private val dao: ProductInfoDao,
    private val api: ProductInfoService
) : ProductInfoRepository {
    override suspend fun getProductsInfo(callBack: (Resource<List<ProductInfoModel>>) -> Unit) {

        //val result = dao.getProductsInfo().map { it.toProductInfoModel() }
        val remoteData = api.getProductsInfo()

        try {
            dao.deleteAllProducts()
            dao.addProducts(remoteData.map { it.toProductsInfoEntity() }.toList())
            callBack(Resource.Success<List<ProductInfoModel>>(remoteData.map { it.toProductsInfoModel() }
                .toList()))


        } catch (e: IOException) {

            callBack(Resource.Error<List<ProductInfoModel>>("An error ocurred ${e.localizedMessage}"))

        }

        callBack(Resource.Success<List<ProductInfoModel>>(remoteData.map { it.toProductsInfoModel() }
            .toList()))
    }
}