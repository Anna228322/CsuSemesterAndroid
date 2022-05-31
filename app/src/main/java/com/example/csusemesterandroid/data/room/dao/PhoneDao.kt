package com.example.csusemesterandroid.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.csusemesterandroid.data.room.models.PhoneData

@Dao
interface PhoneDao {
    @Query("select * from phone")
    suspend fun getAll(): List<PhoneData>

    @Insert
    suspend fun saveAll(vararg data: PhoneData)
}