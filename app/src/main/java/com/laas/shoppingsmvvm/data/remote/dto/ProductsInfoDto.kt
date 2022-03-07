package com.laas.shoppingsmvvm.data.remote.dto

import com.laas.shoppingsmvvm.data.local.entity.ProductInfoEntity
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel

data class ProductsInfoDto(
    val productName: String,
    val productPrice: Float,
    val productRating: Float,
    val productCurrency: String,
    val productReviews: Int,
    val id: Int

) {
    fun toProductsInfoEntity(): ProductInfoEntity {
        return ProductInfoEntity(
            productName = productName,
            productPrice = productPrice,
            productRating = productRating,
            productCurrency = productCurrency,
            productReviews = productReviews,
            id = id
        )
    }

    fun toProductsInfoModel(): ProductInfoModel {
        return ProductInfoModel(
            productName = productName,
            productPrice = productPrice,
            productRating = productRating,
            productCurrency = productCurrency,
            productReviews = productReviews,
            id = id
        )
    }
}

