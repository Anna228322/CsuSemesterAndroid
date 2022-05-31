package com.example.csusemesterandroid.dagger.modules

import android.content.Context
import androidx.room.Room
import com.example.csusemesterandroid.data.room.RoomDatabase
import dagger.Module
import dagger.Provides

@Module
class RoomModule {
    @Provides fun roomDatabase(context: Context) =
        Room.databaseBuilder(context, RoomDatabase::class.java, "db")
            .fallbackToDestructiveMigration().build()
    @Provides fun brandDao(roomDatabase: RoomDatabase) = roomDatabase.brandDao()
    @Provides fun phoneDao(roomDatabase: RoomDatabase) = roomDatabase.phoneDao()
    @Provides fun detailsDao(roomDatabase: RoomDatabase) = roomDatabase.detailsDao()
}