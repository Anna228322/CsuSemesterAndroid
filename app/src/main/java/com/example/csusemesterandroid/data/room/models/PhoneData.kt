package com.example.csusemesterandroid.data.room.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "phone")
data class PhoneData(
    val brand: String,
    val name: String,
    val slug: String,
    val image: String,
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
)
