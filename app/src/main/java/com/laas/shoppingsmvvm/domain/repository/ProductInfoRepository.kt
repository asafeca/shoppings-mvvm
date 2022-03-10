package com.laas.shoppingsmvvm.domain.repository

import com.laas.shoppingsmvvm.core.util.Resource
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel

interface ProductInfoRepository {
    suspend  fun getProductsInfo(callBack:(Resource<List<ProductInfoModel>>)-> Unit)
}