package com.example.csusemesterandroid.data.repository

import com.example.csusemesterandroid.domain.models.BrandInfo
import com.example.csusemesterandroid.domain.models.PhoneInfo

interface PhonesRepo {
    suspend fun getFromApi(brand: BrandInfo): List<PhoneInfo>
    suspend fun getFromDb(brand: BrandInfo): List<PhoneInfo>
    suspend fun saveAll(phones: List<PhoneInfo>)
}