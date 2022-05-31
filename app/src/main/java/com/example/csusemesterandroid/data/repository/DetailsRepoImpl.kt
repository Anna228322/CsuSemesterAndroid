package com.example.csusemesterandroid.data.repository

import com.example.csusemesterandroid.data.api.PhonesApi
import com.example.csusemesterandroid.data.room.dao.DetailsDao
import com.example.csusemesterandroid.domain.models.DetailsInfo
import com.example.csusemesterandroid.domain.models.PhoneInfo
import com.example.csusemesterandroid.mappers.DBEntityMapper
import com.example.csusemesterandroid.mappers.ResponseMapper
import javax.inject.Inject

class DetailsRepoImpl @Inject constructor(
    private val settingsRepository: SettingsRepo,
    private val api: PhonesApi,
    private val responseMapper: ResponseMapper,
    private val entityMapper: DBEntityMapper,
    private val dao: DetailsDao
): DetailsRepo {
    override suspend fun getFromApi(phone: PhoneInfo): DetailsInfo {
        return responseMapper.responseToInfo(api.getDetails(phone.slug))
    }

    override suspend fun getFromDb(phone: PhoneInfo): DetailsInfo? {
        if (settingsRepository.isDbEnabled()) {
            return dao.getAll().filter { data -> data.name == phone.name }.map { data -> entityMapper.dataToInfo(data) }.getOrNull(0)
        } else {
            return null
        }
    }

    override suspend fun saveAll(details: DetailsInfo) {
        if (settingsRepository.isDbEnabled()) {
            dao.saveAll(entityMapper.infoToData(details))
        }
    }
}