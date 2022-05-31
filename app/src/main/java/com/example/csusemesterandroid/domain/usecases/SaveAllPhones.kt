package com.example.csusemesterandroid.domain.usecases

import com.example.csusemesterandroid.domain.models.PhoneInfo

interface SaveAllPhones {
    suspend fun save(phones: List<PhoneInfo>)
}