package com.laas.shoppingsmvvm.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.laas.shoppingsmvvm.core.util.Resource
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel
import com.laas.shoppingsmvvm.domain.model.ProductInfoState
import com.laas.shoppingsmvvm.domain.usecase.GetProductsInfo
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductInfoViewModel @Inject constructor(private val getProductsInfo: GetProductsInfo) :
    ViewModel() {

    private var _state = mutableStateOf(ProductInfoState())
    val state: State<ProductInfoState> = _state

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var searchJob: Job? = null


     fun onGet(callBack:(Resource<List<ProductInfoModel>>)-> Unit){
         GlobalScope.launch {
             getProductsInfo{result->
                 callBack(result)
             }

         }


    }

    sealed class UIEvent() {
        data class ShowSnackbar(val message: String) : UIEvent()
    }
}