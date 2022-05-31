package com.example.csusemesterandroid.data.api

import com.example.csusemesterandroid.data.api.models.BrandsResponse
import com.example.csusemesterandroid.data.api.models.DetailsResponse
import com.example.csusemesterandroid.data.api.models.PhonesResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PhonesApi {
    @GET("brands")
    suspend fun getBrands(): BrandsResponse
    @GET("brands/{brand}")
    suspend fun getPhones(@Path("brand") brand: String): PhonesResponse
    @GET("{phone}")
    suspend fun getDetails(@Path("phone") phone: String): DetailsResponse
}