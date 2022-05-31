package com.example.csusemesterandroid.domain.usecases

import com.example.csusemesterandroid.domain.models.DetailsInfo

interface SavePhoneDetails {
    suspend fun save(details: DetailsInfo)
}