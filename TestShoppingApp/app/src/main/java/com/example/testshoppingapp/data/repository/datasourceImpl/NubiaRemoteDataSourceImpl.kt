package com.example.testshoppingapp.data.repository.datasourceImpl

import com.example.testshoppingapp.data.api.NubiaApiService
import com.example.testshoppingapp.data.model.*
import com.example.testshoppingapp.data.repository.datasource.NubiaRemoteDataSource
import retrofit2.Response
import javax.inject.Inject

class NubiaRemoteDataSourceImpl @Inject constructor(
    private val apiService: NubiaApiService
) : NubiaRemoteDataSource {
    override suspend fun getAllProducts(): Response<Shop> {
        return apiService.getAllProducts()
    }

    override suspend fun loginUser(login: Login): Response<LoginResponse> {
        return apiService.loginUser(login)
    }

}