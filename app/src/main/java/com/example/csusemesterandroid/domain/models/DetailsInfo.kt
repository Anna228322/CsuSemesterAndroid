package com.example.csusemesterandroid.domain.models

data class DetailsInfo(
    val brand: String,
    val name: String,
    val date: String,
    val dimension: String,
    val os: String,
    val storage: String,
    val images: List<String>,
)