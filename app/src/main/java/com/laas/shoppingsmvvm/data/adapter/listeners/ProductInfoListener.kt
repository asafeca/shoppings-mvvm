package com.laas.shoppingsmvvm.data.adapter.listeners

import com.laas.shoppingsmvvm.domain.model.ProductInfoModel

interface ProductInfoListener {
    fun onProductClick(product: ProductInfoModel)
}