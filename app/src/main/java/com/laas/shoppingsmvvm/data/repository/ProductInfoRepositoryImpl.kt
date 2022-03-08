package com.laas.shoppingsmvvm.data.repository

import com.laas.shoppingsmvvm.core.util.Resource
import com.laas.shoppingsmvvm.data.local.dao.ProductInfoDao
import com.laas.shoppingsmvvm.data.remote.ProductInfoService
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel
import com.laas.shoppingsmvvm.domain.repository.ProductInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class ProductInfoRepositoryImpl(
    private val dao: ProductInfoDao,
    private val api: ProductInfoService
) : ProductInfoRepository {
    override fun getProductsInfo(): Flow<Resource<List<ProductInfoModel>>> = flow {
        emit(Resource.Loading())

        val result = dao.getProductsInfo().map { it.toProductInfoModel() }
        emit(Resource.Loading<List<ProductInfoModel>>(data = result))

        try {
            val remoteData = api.getProductsInfo()
            dao.deleteAllProducts()
            dao.addProducts(remoteData.map { it.toProductsInfoEntity() })
            emit(Resource.Success<List<ProductInfoModel>>(remoteData.map { it.toProductsInfoModel() }))

        } catch (e: IOException) {

            emit(
                Resource.Error<List<ProductInfoModel>>(
                    message = "An error occured: ${e.localizedMessage}",
                    data = result
                )
            )

        } catch (e: HttpException) {

            emit(
                Resource.Error<List<ProductInfoModel>>(
                    message = "An error occured: ${e.localizedMessage}",
                    data = result
                )
            )

        }

    }
}