package com.example.testshoppingapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testshoppingapp.data.model.CartItemToSave
import com.example.testshoppingapp.data.model.ShopItem

@Database(entities = [CartItemToSave::class, ShopItem::class], version = 3, exportSchema = false)
abstract class NubiaDatabase : RoomDatabase(){
    abstract fun nubiaDao() : NubiaDAO
}