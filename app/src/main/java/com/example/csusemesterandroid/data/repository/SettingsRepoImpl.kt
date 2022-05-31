package com.example.csusemesterandroid.data.repository

import com.example.csusemesterandroid.data.storage.SettingsStorage
import javax.inject.Inject

class SettingsRepoImpl @Inject constructor(
    private val storage: SettingsStorage
): SettingsRepo {
    override fun isNightMode(): Boolean {
        return storage.getNightModeUsing()
    }

    override fun switchNightMode(): Boolean {
        val old = storage.getNightModeUsing()
        storage.storeNightModeUsing(!old)
        return !old
    }

    override fun isDbEnabled(): Boolean {
        return storage.getDbUsing()
    }

    override fun switchDb(): Boolean {
        val old = storage.getDbUsing()
        storage.storeDbUsing(!old)
        return !old
    }
}