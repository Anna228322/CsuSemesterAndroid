package com.example.csusemesterandroid.mappers

import com.example.csusemesterandroid.data.api.models.BrandsResponse
import com.example.csusemesterandroid.data.api.models.DetailsResponse
import com.example.csusemesterandroid.data.api.models.PhonesResponse
import com.example.csusemesterandroid.domain.models.BrandInfo
import com.example.csusemesterandroid.domain.models.DetailsInfo
import com.example.csusemesterandroid.domain.models.PhoneInfo
import javax.inject.Inject

class ResponseMapper @Inject constructor() {
    fun responseToInfo(response: DetailsResponse): DetailsInfo {
        val dto = response.data
        return DetailsInfo(dto.brand, dto.phone_name, dto.release_date, dto.dimension, dto.os, dto.storage, dto.phone_images)
    }

    fun responseToInfo(response: PhonesResponse): List<PhoneInfo> {
        return response.data.phones.map { dto ->
            PhoneInfo(dto.brand, dto.phone_name, dto.slug, dto.image)
        }
    }

    fun responseToInfo(response: BrandsResponse): List<BrandInfo> {
        return response.data.map { dto ->
            BrandInfo(dto.brand_name, dto.device_count, dto.brand_slug)
        }
    }
}