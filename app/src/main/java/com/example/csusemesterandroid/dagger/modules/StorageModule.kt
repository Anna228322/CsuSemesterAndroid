package com.example.csusemesterandroid.dagger.modules

import com.example.csusemesterandroid.data.storage.SettingsStorage
import com.example.csusemesterandroid.data.storage.SettingsStorageImpl
import dagger.Binds
import dagger.Module

@Module
abstract class StorageModule {
    @Binds abstract fun settingsStorage(settingsStorageImpl: SettingsStorageImpl): SettingsStorage
}