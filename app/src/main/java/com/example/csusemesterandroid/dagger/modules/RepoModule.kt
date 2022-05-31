package com.example.csusemesterandroid.dagger.modules

import com.example.csusemesterandroid.data.repository.*
import dagger.Binds
import dagger.Module

@Module
abstract class RepoModule {
    @Binds abstract fun brandsRepo(brandsRepo: BrandsRepoImpl): BrandsRepo
    @Binds abstract fun phonesRepo(phonesRepo: PhonesRepoImpl): PhonesRepo
    @Binds abstract fun detailsRepo(detailsRepo: DetailsRepoImpl): DetailsRepo
    @Binds abstract fun settingsRepo(settingsRepo: SettingsRepoImpl): SettingsRepo
}