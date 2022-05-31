package com.example.csusemesterandroid.domain.usecases

import com.example.csusemesterandroid.domain.models.BrandInfo

interface GetAllBrands {
    suspend fun fromDb(): List<BrandInfo>
    suspend fun fromApi(): List<BrandInfo>
}