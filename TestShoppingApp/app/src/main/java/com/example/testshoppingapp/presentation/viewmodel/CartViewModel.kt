package com.example.testshoppingapp.presentation.viewmodel

import androidx.lifecycle.*
import com.example.testshoppingapp.data.model.CartItemToSave
import com.example.testshoppingapp.domain.usecase.CartUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val cartUseCase: CartUseCase
) : ViewModel() {
    fun getCartItems() = liveData {
        cartUseCase.getCartItems().collect{
            emit(it)
        }
    }

    fun deleteCart(cartItemToSave: CartItemToSave) = viewModelScope.launch(IO) {
        cartUseCase.deleteCartItem(cartItemToSave)
    }

    fun clearCart() = viewModelScope.launch(IO) {
        cartUseCase.clearCart()
    }
}