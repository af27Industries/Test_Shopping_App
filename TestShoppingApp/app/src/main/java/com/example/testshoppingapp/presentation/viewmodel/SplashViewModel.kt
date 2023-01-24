package com.example.testshoppingapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.example.testshoppingapp.data.util.SharedPreference
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    sharedPreference: SharedPreference
) : ViewModel() {
    val loggedIn : Boolean = sharedPreference.userIsLogged()
}