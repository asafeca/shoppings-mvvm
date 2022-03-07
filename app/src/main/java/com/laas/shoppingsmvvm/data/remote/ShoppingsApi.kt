package com.laas.shoppingsmvvm.data.remote

import com.laas.shoppingsmvvm.data.remote.dto.ProductsInfoDto
import retrofit2.http.GET

interface ShoppingsApi {
    @GET("")
    suspend fun getProductsInfo():List<ProductsInfoDto>

    companion object{
        const val BASE_URL = "my_remote_url"
    }
}