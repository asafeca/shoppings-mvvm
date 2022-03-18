package com.laas.shoppingsmvvm.data.local.entity
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel

@Entity(tableName = "productinfo")
data class ProductInfoEntity(
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
    @PrimaryKey val id: Int

) {
    fun toProductInfoModel(): ProductInfoModel {
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
