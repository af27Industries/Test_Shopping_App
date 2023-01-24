package com.example.testshoppingapp.domain.usecase

import com.example.testshoppingapp.data.model.CartItemToSave
import com.example.testshoppingapp.domain.repository.NubiaRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartUseCase @Inject constructor(
    private val repository: NubiaRepository
) {

    suspend fun deleteCartItem(cartItemToSave: CartItemToSave){
        repository.deleteCartItems(cartItemToSave)
    }

    suspend fun clearCart(){
        repository.clearCart()
    }

    fun getCartItems() : Flow<List<CartItemToSave>> {
        return repository.getCartItems()
    }

    suspend fun addToCartItem(cartItemToSave: CartItemToSave){
        repository.addToCartItems(cartItemToSave)
    }

}