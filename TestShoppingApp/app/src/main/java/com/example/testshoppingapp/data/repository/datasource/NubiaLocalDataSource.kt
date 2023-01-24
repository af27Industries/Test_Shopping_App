package com.example.testshoppingapp.data.repository.datasource

import com.example.testshoppingapp.data.model.CartItemToSave
import com.example.testshoppingapp.data.model.ShopItem
import kotlinx.coroutines.flow.Flow

interface NubiaLocalDataSource {
    suspend fun addToCart(cartItemToSave: CartItemToSave)
    fun getCartItems() : Flow<List<CartItemToSave>>
    suspend fun deleteCartItems(cartItemToSave: CartItemToSave)
    suspend fun clearCart()
}