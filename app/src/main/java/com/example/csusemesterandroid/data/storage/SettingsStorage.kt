package com.example.csusemesterandroid.data.storage

interface SettingsStorage {
    fun storeNightModeUsing(value: Boolean)
    fun storeDbUsing(value: Boolean)
    fun getNightModeUsing(): Boolean
    fun getDbUsing(): Boolean
}