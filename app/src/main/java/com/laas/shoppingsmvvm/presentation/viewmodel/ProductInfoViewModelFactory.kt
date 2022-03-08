package com.laas.shoppingsmvvm.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.laas.shoppingsmvvm.domain.usecase.GetProductsInfo

class ProductInfoViewModelFactory(private val getProductsInfo:GetProductsInfo):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductInfoViewModel(getProductsInfo) as T
    }
}