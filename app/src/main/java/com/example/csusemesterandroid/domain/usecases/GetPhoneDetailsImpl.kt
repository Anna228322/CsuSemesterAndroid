package com.example.csusemesterandroid.domain.usecases

import com.example.csusemesterandroid.data.repository.DetailsRepo
import com.example.csusemesterandroid.domain.models.DetailsInfo
import com.example.csusemesterandroid.domain.models.PhoneInfo
import javax.inject.Inject

class GetPhoneDetailsImpl @Inject constructor(
    private val detailsRepository: DetailsRepo
): GetPhoneDetails {
    override suspend fun fromDb(phone: PhoneInfo): DetailsInfo? {
        return detailsRepository.getFromDb(phone)
    }

    override suspend fun fromApi(phone: PhoneInfo): DetailsInfo {
        return detailsRepository.getFromApi(phone)
    }
}