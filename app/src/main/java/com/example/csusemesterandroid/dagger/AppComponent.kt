package com.example.csusemesterandroid.dagger

import com.example.csusemesterandroid.dagger.modules.*
import com.example.csusemesterandroid.ui.MainActivity
import com.example.csusemesterandroid.ui.SettingsFragment
import dagger.Component

@Component(modules = [
    AppModule::class,
    MappersModule::class,
    UseCasesModule::class,
    StorageModule::class,
    RoomModule::class,
    RepoModule::class,
    ApiModule::class,
    ViewModelModule::class
])
interface AppComponent {
    fun viewModelFactory(): ViewModelFactory
    fun inject(activity: MainActivity)
    fun inject(fragment: SettingsFragment)
}