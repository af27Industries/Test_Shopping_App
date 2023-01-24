package com.example.testshoppingapp.presentation.di

import android.app.Application
import androidx.room.Room
import com.example.testshoppingapp.data.db.NubiaDAO
import com.example.testshoppingapp.data.db.NubiaDatabase
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Singleton
    @Provides
    fun providesShopDatabase(app : Application) : NubiaDatabase{
        return Room.databaseBuilder(app,NubiaDatabase::class.java,"nubia_database")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesNubiaDao(database: NubiaDatabase) : NubiaDAO{
        return database.nubiaDao()
    }

}