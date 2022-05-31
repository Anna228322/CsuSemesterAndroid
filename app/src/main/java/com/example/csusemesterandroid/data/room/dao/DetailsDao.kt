package com.example.csusemesterandroid.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.csusemesterandroid.data.room.models.DetailsData

@Dao
interface DetailsDao {
    @Query("select * from details")
    suspend fun getAll(): List<DetailsData>

    @Insert
    suspend fun saveAll(vararg data: DetailsData)
}