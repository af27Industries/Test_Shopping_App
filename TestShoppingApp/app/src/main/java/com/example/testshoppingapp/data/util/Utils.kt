package com.example.testshoppingapp.data.util

import com.example.testshoppingapp.data.model.ResponseResult

object Utils {

    fun formatPrice(price : String): String {
        return String.format("%.2f", price.toDouble())
    }

    fun checkLoginRequestFields(username: String, password: String) : ResponseResult {
        if (username.isBlank() && password.isBlank()) return ResponseResult(false,"You must enter an user and password")
        if (username.isBlank()) return ResponseResult(false,"Username is empty")
        if (password.isBlank()) return ResponseResult(false,"Password is empty")
        return ResponseResult(true)
    }

}