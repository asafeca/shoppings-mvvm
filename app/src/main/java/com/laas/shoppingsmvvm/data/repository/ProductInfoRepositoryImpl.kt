package com.laas.shoppingsmvvm.data.repository

import com.laas.shoppingsmvvm.core.util.Resource
import com.laas.shoppingsmvvm.data.local.dao.ProductInfoDao
import com.laas.shoppingsmvvm.data.remote.ProductInfoService
import com.laas.shoppingsmvvm.data.remote.dto.ProductsInfoDto
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel
import com.laas.shoppingsmvvm.domain.repository.ProductInfoRepository

import java.io.IOException

class ProductInfoRepositoryImpl(
    private val dao: ProductInfoDao,
    private val api: ProductInfoService
) : ProductInfoRepository {
    override suspend fun getProductsInfo(callBack: (Resource<List<ProductInfoModel>>) -> Unit) {

        val result = dao.getProductsInfo().map { it.toProductInfoModel() }

        try {
            val remoteData = getData()//api.getProductsInfo()
            dao.deleteAllProducts()
            dao.addProducts(remoteData.map { it.toProductsInfoEntity() })
            callBack(Resource.Success<List<ProductInfoModel>>(remoteData.map { it.toProductsInfoModel() }))

        } catch (e: IOException) {

            callBack(Resource.Error<List<ProductInfoModel>>("An error ocurred ${e.localizedMessage}"))

        }

        callBack(Resource.Success<List<ProductInfoModel>>(result))

    }

    fun getData(): List<ProductsInfoDto> {
        var products: ArrayList<ProductsInfoDto> = arrayListOf(
            ProductsInfoDto(
                productName = "HeadSets one",
                productPrice = 100F,
                productCurrency = "R$",
                productRating = 1.5F,
                productReviews = 100,
                id = 1
            ),
            ProductsInfoDto(
                productName = "HeadSets Two",
                productPrice = 200F,
                productCurrency = "R$",
                productRating = 4.2F,
                productReviews = 200,
                id = 1
            ),

            ProductsInfoDto(
                productName = "HeadSets Three",
                productPrice = 300F,
                productCurrency = "R$",
                productRating = 4.3F,
                productReviews = 3000,
                id = 1
            ),
            ProductsInfoDto(
                productName = "HeadSets Four",
                productPrice = 400F,
                productCurrency = "R$",
                productRating = 4.4F,
                productReviews = 400,
                id = 1
            ),
            ProductsInfoDto(
                productName = "HeadSets Five",
                productPrice = 500F,
                productCurrency = "R$",
                productRating = 4.5F,
                productReviews = 500,
                id = 1
            ),
            ProductsInfoDto(
                productName = "HeadSets Six",
                productPrice = 600F,
                productCurrency = "R$",
                productRating = 4.6F,
                productReviews = 600,
                id = 1
            ),
            ProductsInfoDto(
                productName = "HeadSets Seven",
                productPrice = 700F,
                productCurrency = "R$",
                productRating = 4.7F,
                productReviews = 700,
                id = 1
            )

        )
        return products
    }
}