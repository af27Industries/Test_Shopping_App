package com.example.testshoppingapp.presentation.di

import com.example.testshoppingapp.data.api.NubiaApiService
import com.example.testshoppingapp.data.db.NubiaDAO
import com.example.testshoppingapp.data.repository.datasource.NubiaLocalDataSource
import com.example.testshoppingapp.data.repository.datasource.NubiaRemoteDataSource
import com.example.testshoppingapp.data.repository.datasourceImpl.NubiaLocalDataSourceImpl
import com.example.testshoppingapp.data.repository.datasourceImpl.NubiaRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun providesLocalDataSource(nubiaDAO: NubiaDAO) : NubiaLocalDataSource {
        return NubiaLocalDataSourceImpl(nubiaDAO)
    }

    @Singleton
    @Provides
    fun provideShopRemoteDataSource(nubiaApiService: NubiaApiService) : NubiaRemoteDataSource {
        return NubiaRemoteDataSourceImpl(nubiaApiService)
    }

}