package com.example.csusemesterandroid.data.repository

import com.example.csusemesterandroid.domain.models.BrandInfo

interface BrandsRepo {
    suspend fun getFromApi(): List<BrandInfo>
    suspend fun getFromDb(): List<BrandInfo>
    suspend fun saveAll(brands: List<BrandInfo>)
}