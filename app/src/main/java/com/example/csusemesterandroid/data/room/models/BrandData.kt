package com.example.csusemesterandroid.data.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "brand")
data class BrandData(
    val name: String,
    val count: Int,
    val slug: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
)