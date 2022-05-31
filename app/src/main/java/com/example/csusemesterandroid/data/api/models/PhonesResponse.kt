package com.example.csusemesterandroid.data.api.models

data class PhonesResponse(
    val data: Data
) {
    data class Data(
        val phones: List<PhoneDto>
    ) {
        data class PhoneDto(
            val brand: String,
            val phone_name: String,
            val slug: String,
            val image: String,
        )
    }
}