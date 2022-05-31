package com.example.csusemesterandroid.data.repository

interface SettingsRepo {
    fun isNightMode(): Boolean
    fun switchNightMode(): Boolean

    fun isDbEnabled(): Boolean
    fun switchDb(): Boolean
}