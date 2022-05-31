package com.example.csusemesterandroid.data.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "details")
data class DetailsData(
    val brand: String,
    val name: String,
    val date: String,
    val dimension: String,
    val os: String,
    val storage: String,
    val images: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
)