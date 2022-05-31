package com.example.csusemesterandroid.domain.usecases

import com.example.csusemesterandroid.data.repository.BrandsRepo
import com.example.csusemesterandroid.domain.models.BrandInfo
import javax.inject.Inject

class SaveAllBrandsImpl @Inject constructor(
    private val brandsRepository: BrandsRepo
): SaveAllBrands {
    override suspend fun save(brands: List<BrandInfo>) {
        brandsRepository.saveAll(brands)
    }
}