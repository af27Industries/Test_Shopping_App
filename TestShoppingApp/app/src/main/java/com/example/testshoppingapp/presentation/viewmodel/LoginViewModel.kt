package com.example.testshoppingapp.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testshoppingapp.data.util.Resource
import com.example.testshoppingapp.data.util.SharedPreference
import com.example.testshoppingapp.domain.usecase.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val authUseCase: AuthUseCase,
    private val sharedPrefUtil: SharedPreference,
) : ViewModel(){

    val successful : MutableLiveData<Boolean?> = MutableLiveData()
    val error : MutableLiveData<String?> = MutableLiveData()

    private fun saveAccessToken(token: String) = sharedPrefUtil.saveUserAccessToken(token)

    fun loginUser(username: String, password: String){
        authUseCase.loginUser(username, password).onEach { result ->
            when(result) {
                is Resource.Error -> {
                    error.postValue("${result.message}")
                    successful.postValue(false)
                }
                is Resource.Success -> {
                    successful.postValue(true)
                    saveAccessToken("${result.data?.token}")
                }
                is Resource.Loading -> {
                    // Loading
                }
            }
        }.launchIn(viewModelScope)
    }

    fun navigated(){
        successful.postValue(null)
        error.postValue(null)
    }

}