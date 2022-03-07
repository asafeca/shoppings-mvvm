package com.laas.shoppingsmvvm.data.util

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel

@ProvidedTypeConverter
class Converter(private val jsonParser: JsonParser) {

    @TypeConverter
    fun fromProductInfoJson(json: String): List<ProductInfoModel> {
        return jsonParser.fromJson<ArrayList<ProductInfoModel>>(
            json,
            object : TypeToken<ArrayList<ProductInfoModel>>() {}?.type
        ) ?: emptyList()

    }

    fun toProductInfoJson(products: List<ProductInfoModel>): String {
        return jsonParser.toJson(products,
            object : TypeToken<ArrayList<ProductInfoModel>>() {}?.type
        ) ?: "[]"
    }
}