package com.example.testshoppingapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testshoppingapp.data.model.CartItemToSave
import com.example.testshoppingapp.domain.usecase.CartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailViewModel  @Inject constructor(private val cartUseCase: CartUseCase) : ViewModel() {

    fun saveToCart(cartItemToSave: CartItemToSave) = viewModelScope.launch(IO) {
        cartUseCase.addToCartItem(cartItemToSave)
    }
}