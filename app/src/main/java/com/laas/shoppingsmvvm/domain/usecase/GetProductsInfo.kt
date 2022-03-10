package com.laas.shoppingsmvvm.domain.usecase

import com.laas.shoppingsmvvm.core.util.Resource
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel
import com.laas.shoppingsmvvm.domain.repository.ProductInfoRepository

class GetProductsInfo(private val repository: ProductInfoRepository) {
    suspend operator  fun invoke(callBack:(Resource<List<ProductInfoModel>>)->Unit) {
        repository.getProductsInfo{result->
            callBack(result)
      }
    }
}