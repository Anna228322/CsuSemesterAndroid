package com.example.csusemesterandroid.domain.usecases

import com.example.csusemesterandroid.data.repository.PhonesRepo
import com.example.csusemesterandroid.domain.models.BrandInfo
import com.example.csusemesterandroid.domain.models.PhoneInfo
import javax.inject.Inject

class GetAllPhonesImpl @Inject constructor(
    private val phonesRepository: PhonesRepo
): GetAllPhones {
    override suspend fun fromDb(brand: BrandInfo): List<PhoneInfo> {
        return phonesRepository.getFromDb(brand)
    }

    override suspend fun fromApi(brand: BrandInfo): List<PhoneInfo> {
        return phonesRepository.getFromApi(brand)
    }
}