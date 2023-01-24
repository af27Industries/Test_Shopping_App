package com.example.testshoppingapp.domain.usecase

import com.example.testshoppingapp.data.model.Shop
import com.example.testshoppingapp.data.util.Resource
import com.example.testshoppingapp.domain.repository.NubiaRepository
import javax.inject.Inject

class ProductUseCase @Inject constructor(
    private val repository: NubiaRepository
) {
    suspend fun getAllProducts() : Resource<Shop> {
        return repository.getAllProducts()
    }
}