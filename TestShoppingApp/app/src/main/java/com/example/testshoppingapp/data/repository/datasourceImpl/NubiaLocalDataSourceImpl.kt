package com.example.testshoppingapp.data.repository.datasourceImpl

import com.example.testshoppingapp.data.db.NubiaDAO
import com.example.testshoppingapp.data.model.CartItemToSave
import com.example.testshoppingapp.data.model.ShopItem
import com.example.testshoppingapp.data.repository.datasource.NubiaLocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NubiaLocalDataSourceImpl @Inject constructor(
    private val nubiaDAO: NubiaDAO
)  : NubiaLocalDataSource {
    override suspend fun addToCart(cartItemToSave: CartItemToSave) {
        return nubiaDAO.addToCart(cartItemToSave)
    }

    override fun getCartItems(): Flow<List<CartItemToSave>> {
        return nubiaDAO.cartItems()
    }

    override suspend fun deleteCartItems(cartItemToSave: CartItemToSave) {
        return nubiaDAO.deleteCart(cartItemToSave)
    }

    override suspend fun clearCart() {
        return nubiaDAO.clearAll()
    }
}