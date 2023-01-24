package com.example.testshoppingapp.presentation.di

import com.example.testshoppingapp.domain.repository.NubiaRepository
import com.example.testshoppingapp.domain.usecase.AuthUseCase
import com.example.testshoppingapp.domain.usecase.CartUseCase
import com.example.testshoppingapp.domain.usecase.ProductUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {


    @Singleton
    @Provides
    fun providesCartUseCase(repository: NubiaRepository) : CartUseCase {
        return CartUseCase(repository)
    }

    @Singleton
    @Provides
    fun providesProductUseCase(repository: NubiaRepository) : ProductUseCase {
        return ProductUseCase(repository)
    }

    @Singleton
    @Provides
    fun providesAuthUseCase(repository: NubiaRepository) : AuthUseCase {
        return AuthUseCase(repository)
    }

}