package com.example.csusemesterandroid.data.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.csusemesterandroid.data.room.models.BrandData

@Dao
interface BrandDao {
    @Query("select * from brand")
    suspend fun getAll(): List<BrandData>

    @Insert
    suspend fun saveAll(vararg data: BrandData)
}