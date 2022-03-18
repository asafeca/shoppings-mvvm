package com.laas.shoppingsmvvm.data.remote

import com.laas.shoppingsmvvm.data.remote.dto.ProductsInfoDto
import retrofit2.http.GET

interface ProductInfoService {
    @GET("https://mocki.io/v1/a940368b-48d0-4ffc-b6a3-3d0f86d94ad3")
    suspend fun getProductsInfo():List<ProductsInfoDto>
}