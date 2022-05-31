package com.example.csusemesterandroid

import android.app.Application
import androidx.fragment.app.Fragment
import com.example.csusemesterandroid.dagger.AppComponent
import com.example.csusemesterandroid.dagger.DaggerAppComponent
import com.example.csusemesterandroid.dagger.modules.AppModule

class App: Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        fun Fragment.viewModelFactory() =
            (requireContext().applicationContext as App).appComponent.viewModelFactory()
    }
}