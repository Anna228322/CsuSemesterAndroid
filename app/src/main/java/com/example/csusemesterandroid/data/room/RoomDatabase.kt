package com.example.csusemesterandroid.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.csusemesterandroid.data.room.dao.BrandDao
import com.example.csusemesterandroid.data.room.dao.DetailsDao
import com.example.csusemesterandroid.data.room.dao.PhoneDao
import com.example.csusemesterandroid.data.room.models.BrandData
import com.example.csusemesterandroid.data.room.models.DetailsData
import com.example.csusemesterandroid.data.room.models.PhoneData

@Database(entities = [PhoneData::class, DetailsData::class, BrandData::class], version = 1)
abstract class RoomDatabase: RoomDatabase() {
    abstract fun phoneDao(): PhoneDao
    abstract fun brandDao(): BrandDao
    abstract fun detailsDao(): DetailsDao
}