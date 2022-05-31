package com.example.csusemesterandroid.data.repository

import com.example.csusemesterandroid.data.api.PhonesApi
import com.example.csusemesterandroid.data.room.dao.PhoneDao
import com.example.csusemesterandroid.domain.models.BrandInfo
import com.example.csusemesterandroid.domain.models.PhoneInfo
import com.example.csusemesterandroid.mappers.DBEntityMapper
import com.example.csusemesterandroid.mappers.ResponseMapper
import javax.inject.Inject

class PhonesRepoImpl @Inject constructor(
    private val settingsRepository: SettingsRepo,
    private val api: PhonesApi,
    private val responseMapper: ResponseMapper,
    private val entityMapper: DBEntityMapper,
    private val dao: PhoneDao
): PhonesRepo {
    override suspend fun getFromApi(brand: BrandInfo): List<PhoneInfo> {
        return responseMapper.responseToInfo(api.getPhones(brand.slug))
    }

    override suspend fun getFromDb(brand: BrandInfo): List<PhoneInfo> {
        if (settingsRepository.isDbEnabled()) {
            return dao.getAll().filter { data -> data.brand == brand.name }.map { data -> entityMapper.dataToInfo(data) }
        } else {
            return emptyList()
        }
    }

    override suspend fun saveAll(phones: List<PhoneInfo>) {
        if (settingsRepository.isDbEnabled()) {
            dao.saveAll(*phones.map { info -> entityMapper.infoToData(info) }.toTypedArray())
        }
    }
}