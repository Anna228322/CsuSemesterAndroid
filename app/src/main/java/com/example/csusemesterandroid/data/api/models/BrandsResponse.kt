package com.example.csusemesterandroid.data.api.models

data class BrandsResponse(
    val data: List<BrandDto>
) {
    data class BrandDto(
        val brand_name: String,
        val brand_slug: String,
        val device_count: Int,
    )
}
