package com.example.csusemesterandroid.data.api.models

data class DetailsResponse(
    val data: DetailsDto
) {
    data class DetailsDto(
        val brand: String,
        val phone_name: String,
        val release_date: String,
        val dimension: String,
        val os: String,
        val storage: String,
        val phone_images: List<String>
    )
}
