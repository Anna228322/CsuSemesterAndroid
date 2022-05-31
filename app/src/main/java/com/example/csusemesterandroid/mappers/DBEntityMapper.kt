package com.example.csusemesterandroid.mappers

import com.example.csusemesterandroid.data.room.models.BrandData
import com.example.csusemesterandroid.data.room.models.DetailsData
import com.example.csusemesterandroid.data.room.models.PhoneData
import com.example.csusemesterandroid.domain.models.BrandInfo
import com.example.csusemesterandroid.domain.models.DetailsInfo
import com.example.csusemesterandroid.domain.models.PhoneInfo
import javax.inject.Inject

class DBEntityMapper @Inject constructor() {
    fun dataToInfo(data: PhoneData): PhoneInfo {
        return PhoneInfo(data.brand, data.name, data.slug, data.image)
    }

    fun dataToInfo(data: BrandData): BrandInfo {
        return BrandInfo(data.name, data.count, data.slug)
    }

    fun dataToInfo(data: DetailsData): DetailsInfo {
        return DetailsInfo(data.brand, data.name, data.date, data.dimension, data.os, data.storage, data.images.split(", "))
    }

    fun infoToData(info: PhoneInfo): PhoneData {
        return PhoneData(info.brand, info.name, info.slug, info.image)
    }

    fun infoToData(info: BrandInfo): BrandData {
        return BrandData(info.name, info.count, info.slug)
    }

    fun infoToData(info: DetailsInfo): DetailsData {
        return DetailsData(info.brand, info.name, info.date, info.dimension, info.os, info.storage, info.images.joinToString(", "))
    }
}