package com.laas.shoppingsmvvm.data.remote

import com.laas.shoppingsmvvm.data.remote.dto.ProductsInfoDto
import retrofit2.http.GET

interface ProductInfoService {
    @GET("/api/v2/entries/en/{word}")
    suspend fun getProductsInfo():List<ProductsInfoDto>
}