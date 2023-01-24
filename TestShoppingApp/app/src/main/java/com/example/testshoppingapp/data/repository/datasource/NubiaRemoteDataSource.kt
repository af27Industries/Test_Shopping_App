package com.example.testshoppingapp.data.repository.datasource

import com.example.testshoppingapp.data.model.*
import retrofit2.Response

interface NubiaRemoteDataSource {

    suspend fun getAllProducts() : Response<Shop>
    suspend fun loginUser(login : Login): Response<LoginResponse>

}