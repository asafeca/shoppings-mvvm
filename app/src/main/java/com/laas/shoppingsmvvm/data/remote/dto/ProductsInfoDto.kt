package com.laas.shoppingsmvvm.data.remote.dto

import com.laas.shoppingsmvvm.data.local.entity.ProductInfoEntity
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel

data class ProductsInfoDto(
    val productName: String,
    val productPrice: Float,
    val productRating: Float,
    val productCurrency: String,
    val productReviews: Int,
    val connectionType: String,
    val compatibility: String,
    val powerSupplySource: String,
    val batteryLifeTime: Float,
    val capture: String,
    val id: Int

) {
    fun toProductsInfoEntity(): ProductInfoEntity {
        return ProductInfoEntity(
            productName = productName,
            productPrice = productPrice,
            productRating = productRating,
            productCurrency = productCurrency,
            productReviews = productReviews,
            connectionType = connectionType,
            compatibility = compatibility,
            powerSupplySource = powerSupplySource,
            batteryLifeTime = batteryLifeTime,
            capture = capture,
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
            connectionType = connectionType,
            compatibility = compatibility,
            powerSupplySource = powerSupplySource,
            batteryLifeTime = batteryLifeTime,
            capture = capture,
            id = id
        )
    }
}

