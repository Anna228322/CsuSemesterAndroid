package com.example.csusemesterandroid.data.storage

import android.content.SharedPreferences
import javax.inject.Inject

class SettingsStorageImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
): SettingsStorage {
    private val nightModeKey = "night"
    private val dbKey = "db"

    override fun storeNightModeUsing(value: Boolean) {
        sharedPreferences.edit().putBoolean(nightModeKey, value).apply()
    }

    override fun storeDbUsing(value: Boolean) {
        sharedPreferences.edit().putBoolean(dbKey, value).apply()
    }

    override fun getNightModeUsing(): Boolean {
        return sharedPreferences.getBoolean(nightModeKey, false)
    }

    override fun getDbUsing(): Boolean {
        return sharedPreferences.getBoolean(dbKey, true)
    }
}