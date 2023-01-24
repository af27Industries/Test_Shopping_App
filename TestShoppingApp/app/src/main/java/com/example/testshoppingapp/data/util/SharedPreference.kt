package com.example.testshoppingapp.data.util

import android.content.SharedPreferences
import javax.inject.Inject

class SharedPreference @Inject constructor(
    private val sharedPreferences : SharedPreferences
) {

    fun userIsLogged() : Boolean {
        val token = sharedPreferences.getString(Constants.USER_IS_LOGGED, null)
        return token != null
    }

    fun saveUserAccessToken(token: String) {
        sharedPreferences.edit().putString(Constants.USER_IS_LOGGED, token).apply()
    }
}