package com.example.csusemesterandroid.domain.usecases

import com.example.csusemesterandroid.domain.models.DetailsInfo
import com.example.csusemesterandroid.domain.models.PhoneInfo

interface GetPhoneDetails {
    suspend fun fromDb(phone: PhoneInfo): DetailsInfo?
    suspend fun fromApi(phone: PhoneInfo): DetailsInfo
}