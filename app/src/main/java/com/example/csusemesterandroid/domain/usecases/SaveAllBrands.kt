package com.example.csusemesterandroid.domain.usecases

import com.example.csusemesterandroid.domain.models.BrandInfo

interface SaveAllBrands {
    suspend fun save(brands: List<BrandInfo>)
}