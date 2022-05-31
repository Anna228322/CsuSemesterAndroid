package com.example.csusemesterandroid.dagger.modules

import com.example.csusemesterandroid.data.api.Retrofit
import dagger.Module
import dagger.Provides

@Module
class ApiModule {
    @Provides fun retrofit() = Retrofit()
    @Provides fun api(retrofit: Retrofit) = retrofit.api
}