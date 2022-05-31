package com.example.csusemesterandroid.dagger.modules

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val context: Context) {
    @Provides fun context() = context
    @Provides fun sharedPrefs(): SharedPreferences = context.getSharedPreferences("prefs", 0)
}