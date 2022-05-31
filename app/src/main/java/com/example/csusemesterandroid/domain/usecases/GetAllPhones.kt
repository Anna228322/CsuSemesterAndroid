package com.example.csusemesterandroid.domain.usecases

import com.example.csusemesterandroid.domain.models.BrandInfo
import com.example.csusemesterandroid.domain.models.PhoneInfo

interface GetAllPhones {
    suspend fun fromDb(brand: BrandInfo): List<PhoneInfo>
    suspend fun fromApi(brand: BrandInfo): List<PhoneInfo>
}