package com.example.testshoppingapp.data.db

import androidx.room.*
import com.example.testshoppingapp.data.model.CartItemToSave
import kotlinx.coroutines.flow.Flow

@Dao
interface NubiaDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addToCart(cartItemToSave: CartItemToSave)

    @Delete
    suspend fun deleteCart(cartItemToSave: CartItemToSave)

    @Query("select * from cart")
    fun cartItems() : Flow<List<CartItemToSave>>

    @Query("delete from cart")
    suspend fun clearAll()


}