package com.laas.shoppingsmvvm.domain.usecase

import com.laas.shoppingsmvvm.core.util.Resource
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel
import com.laas.shoppingsmvvm.domain.repository.ProductInfoRepository
import kotlinx.coroutines.flow.Flow

class GetProductsInfo(private val repository: ProductInfoRepository) {
    operator fun invoke(): Flow<Resource<List<ProductInfoModel>>> {
        return repository.getProductsInfo()
    }
}