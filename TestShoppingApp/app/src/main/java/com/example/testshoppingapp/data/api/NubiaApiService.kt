package com.example.testshoppingapp.data.api

import com.example.testshoppingapp.data.model.*
import retrofit2.Response
import retrofit2.http.*

interface NubiaApiService {

    @GET("/products")
    suspend fun getAllProducts() : Response<Shop>

    @POST("auth/login")
    suspend fun loginUser(@Body login : Login): Response<LoginResponse>
}