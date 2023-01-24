package com.example.testshoppingapp.domain.repository

import com.example.testshoppingapp.data.model.*
import com.example.testshoppingapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NubiaRepository {
    suspend fun getAllProducts() : Resource<Shop>
    suspend fun loginUser(login: Login) : Resource<LoginResponse>
    suspend fun addToCartItems(cartItemToSave: CartItemToSave)
    fun getCartItems() : Flow<List<CartItemToSave>>
    suspend fun deleteCartItems(cartItemToSave: CartItemToSave)
    suspend fun clearCart()
}