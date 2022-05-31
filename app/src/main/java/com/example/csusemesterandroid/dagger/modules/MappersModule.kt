package com.example.csusemesterandroid.dagger.modules

import com.example.csusemesterandroid.mappers.DBEntityMapper
import com.example.csusemesterandroid.mappers.ItemMapper
import com.example.csusemesterandroid.mappers.ResponseMapper
import dagger.Module
import dagger.Provides

@Module
class MappersModule {
    @Provides fun dbEntityMapper() = DBEntityMapper()
    @Provides fun responseMapper() = ResponseMapper()
    @Provides fun itemMapper() = ItemMapper()
}
