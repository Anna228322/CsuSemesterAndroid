package com.example.csusemesterandroid.domain.usecases

import com.example.csusemesterandroid.data.repository.DetailsRepo
import com.example.csusemesterandroid.domain.models.DetailsInfo
import javax.inject.Inject

class SavePhoneDetailsImpl @Inject constructor(
    private val detailsRepository: DetailsRepo
): SavePhoneDetails {
    override suspend fun save(details: DetailsInfo) {
        detailsRepository.saveAll(details)
    }
}