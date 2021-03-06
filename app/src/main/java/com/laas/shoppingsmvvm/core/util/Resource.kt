package com.laas.shoppingsmvvm.core.util

import com.laas.shoppingsmvvm.domain.model.ProductInfoModel
import kotlinx.coroutines.flow.Flow

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Success<T>(data: T?) : Resource<T>(data)
    class Error<T>(message: String? = null,data:T?=null) : Resource<T>(data,message)
}