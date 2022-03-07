package com.laas.shoppingsmvvm.data.local.entity
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel

@Entity(tableName = "product_info_entity")
data class ProductInfoEntity(
    val productName: String,
    val productPrice: Float,
    val productRating: Float,
    val productCurrency: String,
    val productReviews: Int,
    @PrimaryKey val id: Int

) {
    fun toProductInfoModel(): ProductInfoModel {
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
