package com.laas.shoppingsmvvm.domain.model

data class ProductInfoModel(
    val productName: String,
    val productPrice: Float,
    val productRating: Float,
    val productCurrency: String,
    val productReviews: Int,
    val connectionType:String,
    val compatibility:String,
    val powerSupplySource:String,
    val batteryLifeTime:Float,
    val capture:String,
    val id: Int
)