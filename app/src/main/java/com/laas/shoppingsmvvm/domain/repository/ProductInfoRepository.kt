package com.laas.shoppingsmvvm.domain.repository

import com.laas.shoppingsmvvm.core.util.Resource
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel
import kotlinx.coroutines.flow.Flow

interface ProductInfoRepository {
    fun getProductsInfo(): Flow<Resource<List<ProductInfoModel>>>
}