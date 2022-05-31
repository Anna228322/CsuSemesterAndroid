package com.example.csusemesterandroid.data.repository

import com.example.csusemesterandroid.data.api.PhonesApi
import com.example.csusemesterandroid.data.room.dao.BrandDao
import com.example.csusemesterandroid.domain.models.BrandInfo
import com.example.csusemesterandroid.mappers.DBEntityMapper
import com.example.csusemesterandroid.mappers.ResponseMapper
import javax.inject.Inject

class BrandsRepoImpl @Inject constructor(
    private val settingsRepository: SettingsRepo,
    private val api: PhonesApi,
    private val responseMapper: ResponseMapper,
    private val entityMapper: DBEntityMapper,
    private val dao: BrandDao
): BrandsRepo {
    override suspend fun getFromApi(): List<BrandInfo> {
        return responseMapper.responseToInfo(api.getBrands())
    }

    override suspend fun getFromDb(): List<BrandInfo> {
        if (settingsRepository.isDbEnabled()) {
            return dao.getAll().map { data -> entityMapper.dataToInfo(data) }
        } else {
            return emptyList()
        }
    }

    override suspend fun saveAll(brands: List<BrandInfo>) {
        if (settingsRepository.isDbEnabled()) {
            dao.saveAll(*brands.map { info -> entityMapper.infoToData(info) }.toTypedArray())
        }
    }
}