package com.example.testshoppingapp.domain.usecase

import com.example.testshoppingapp.data.model.*
import com.example.testshoppingapp.data.util.Resource
import com.example.testshoppingapp.domain.repository.NubiaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import javax.inject.Inject

class AuthUseCase @Inject constructor(
    private val repository: NubiaRepository
) {
    fun loginUser(username : String, password : String) : Flow<Resource<LoginResponse>> = flow{
        emit(Resource.Loading())
        try {
            val login = Login(username, password)
            val response = repository.loginUser(login)
            emit (response)
        }catch (e : IOException){
            emit (Resource.Error("No Internet. Try again."))
        }
    }
}