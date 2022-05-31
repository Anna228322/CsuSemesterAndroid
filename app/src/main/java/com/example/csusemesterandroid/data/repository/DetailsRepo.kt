package com.example.csusemesterandroid.data.repository

import com.example.csusemesterandroid.domain.models.DetailsInfo
import com.example.csusemesterandroid.domain.models.PhoneInfo

interface DetailsRepo {
    suspend fun getFromApi(phone: PhoneInfo): DetailsInfo
    suspend fun getFromDb(phone: PhoneInfo): DetailsInfo?
    suspend fun saveAll(details: DetailsInfo)
}