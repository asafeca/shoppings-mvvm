package com.laas.shoppingsmvvm.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.laas.shoppingsmvvm.core.util.Resource
import com.laas.shoppingsmvvm.domain.model.ProductInfoModel
import com.laas.shoppingsmvvm.domain.model.ProductInfoState
import com.laas.shoppingsmvvm.domain.usecase.GetProductsInfo
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import okhttp3.internal.userAgent
import javax.inject.Inject

class ProductInfoViewModel @Inject constructor(private val getProductsInfo: GetProductsInfo) :
    ViewModel() {

    private var _state = mutableStateOf(ProductInfoState())
    val state: State<ProductInfoState> = _state

    private val _eventFlow = MutableSharedFlow<UIEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var searchJob: Job? = null


    fun onGet(callBack: (Resource<List<ProductInfoModel>>) -> Unit) {
        getProductsInfo()
            .onEach { result ->
                callBack(result)
            }

        /*

        searchJob?.cancel()

        searchJob = viewModelScope.launch {


            getProductsInfo()

                .onEach { result ->
                    when (result) {

                        is Resource.Success -> {
                            _state.value = state.value.copy(
                                productInfoItems = result.data ?: emptyList(),
                                isLoading = false
                            )

                        }

                        is Resource.Loading -> {

                            _state.value = state.value.copy(
                                productInfoItems = result.data ?: emptyList(),
                                isLoading = true
                            )

                        }
                        is Resource.Error -> {
                            _state.value = state.value.copy(
                                productInfoItems = result.data ?: emptyList(),
                                isLoading = false
                            )
                        }

                    }

                }.launchIn(this)
        }


        */
    }

    sealed class UIEvent() {
        data class ShowSnackbar(val message: String) : UIEvent()
    }
}