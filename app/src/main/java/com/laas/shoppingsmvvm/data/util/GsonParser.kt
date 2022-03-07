package com.laas.shoppingsmvvm.data.util

import java.lang.reflect.Type
import com.google.gson.Gson

class GsonParser(private val gson: Gson) : JsonParser {
    override fun <T> fromJson(json: String, type: Type): T? {
        return gson.fromJson(json, type)
    }

    override fun <T> toJson(obj: Object, type: Type): String? {
        return gson.toJson(obj, type)
    }
}