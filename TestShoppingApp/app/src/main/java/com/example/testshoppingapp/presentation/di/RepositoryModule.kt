package com.example.testshoppingapp.presentation.di

import com.example.testshoppingapp.data.repository.NubiaRepositoryImpl
import com.example.testshoppingapp.data.repository.datasource.NubiaLocalDataSource
import com.example.testshoppingapp.data.repository.datasource.NubiaRemoteDataSource
import com.example.testshoppingapp.domain.repository.NubiaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun providesShopRepository(nubiaRemoteDataSource: NubiaRemoteDataSource,nubiaLocalDataSource: NubiaLocalDataSource) : NubiaRepository {
        return NubiaRepositoryImpl(nubiaRemoteDataSource,nubiaLocalDataSource)
    }

}