package com.example.csusemesterandroid.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    val api: PhonesApi
        get() = getClient().create(PhonesApi::class.java)

    private var retrofit: Retrofit? = null

    private fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl("https://api-mobilespecs.azharimm.site/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit!!
    }
}