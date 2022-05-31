package com.example.csusemesterandroid.dagger.modules

import com.example.csusemesterandroid.domain.usecases.*
import dagger.Binds
import dagger.Module

@Module
abstract class UseCasesModule {
    @Binds abstract fun getAllBrands(getAllBrands: GetAllBrandsImpl): GetAllBrands
    @Binds abstract fun getAllPhones(getAllPhones: GetAllPhonesImpl): GetAllPhones
    @Binds abstract fun getDetails(getPhoneDetails: GetPhoneDetailsImpl): GetPhoneDetails
    @Binds abstract fun saveAllBrands(saveAllBrands: SaveAllBrandsImpl): SaveAllBrands
    @Binds abstract fun saveAllPhones(saveAllPhones: SaveAllPhonesImpl): SaveAllPhones
    @Binds abstract fun saveDetails(savePhoneDetails: SavePhoneDetailsImpl): SavePhoneDetails
}