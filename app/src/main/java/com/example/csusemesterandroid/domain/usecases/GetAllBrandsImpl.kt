package com.example.csusemesterandroid.domain.usecases

import com.example.csusemesterandroid.data.repository.BrandsRepo
import com.example.csusemesterandroid.domain.models.BrandInfo
import javax.inject.Inject

class GetAllBrandsImpl @Inject constructor(
    private val brandsRepository: BrandsRepo
): GetAllBrands {
    override suspend fun fromDb(): List<BrandInfo> {
        return brandsRepository.getFromDb()
    }

    override suspend fun fromApi(): List<BrandInfo> {
        return brandsRepository.getFromApi()
    }
}