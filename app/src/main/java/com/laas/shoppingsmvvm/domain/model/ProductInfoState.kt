package com.laas.shoppingsmvvm.domain.model

data class ProductInfoState(
    var productInfoItems: List<ProductInfoModel> = emptyList(),
    var isLoading: Boolean = false
)
