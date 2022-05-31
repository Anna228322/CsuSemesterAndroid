package com.example.csusemesterandroid.domain.usecases

import com.example.csusemesterandroid.data.repository.PhonesRepo
import com.example.csusemesterandroid.domain.models.PhoneInfo
import javax.inject.Inject

class SaveAllPhonesImpl @Inject constructor(
    private val phonesRepository: PhonesRepo
): SaveAllPhones {
    override suspend fun save(phones: List<PhoneInfo>) {
        phonesRepository.saveAll(phones)
    }
}