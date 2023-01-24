package com.example.testshoppingapp.data.repository

import com.example.testshoppingapp.data.model.*
import com.example.testshoppingapp.data.repository.datasource.NubiaLocalDataSource
import com.example.testshoppingapp.data.repository.datasource.NubiaRemoteDataSource
import com.example.testshoppingapp.data.util.Resource
import com.example.testshoppingapp.domain.repository.NubiaRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import javax.inject.Inject

class NubiaRepositoryImpl @Inject constructor(
    private val remoteDataSource: NubiaRemoteDataSource,
    private val localDataSource: NubiaLocalDataSource
) : NubiaRepository {

    override suspend fun getAllProducts(): Resource<Shop> {
        return responseToShopResult(remoteDataSource.getAllProducts())
    }

    override suspend fun loginUser(login: Login): Resource<LoginResponse> {
        return responseToString(remoteDataSource.loginUser(login))
    }

    override suspend fun addToCartItems(cartItemToSave: CartItemToSave) {
        return localDataSource.addToCart(cartItemToSave)
    }

    override fun getCartItems(): Flow<List<CartItemToSave>> {
        return localDataSource.getCartItems()
    }

    override suspend fun deleteCartItems(cartItemToSave: CartItemToSave) {
        return localDataSource.deleteCartItems(cartItemToSave)
    }

    override suspend fun clearCart() {
        return localDataSource.clearCart()
    }

    private fun responseToString(response: Response<LoginResponse>) : Resource<LoginResponse> {
        if (response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return Resource.Error(message = "${response.errorBody()?.string()}")
    }

    private fun responseToShopResult(response: Response<Shop>) : Resource<Shop> {
        if (response.isSuccessful){
            response.body()?.let { result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(message = "${response.errorBody()?.string()}")
    }

}