package com.example.csusemesterandroid.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.csusemesterandroid.App
import com.example.csusemesterandroid.R
import com.example.csusemesterandroid.data.repository.SettingsRepo
import com.example.csusemesterandroid.databinding.ActivityMainBinding
import com.example.csusemesterandroid.domain.models.BrandInfo
import com.example.csusemesterandroid.domain.models.PhoneInfo
import javax.inject.Inject

class MainActivity: AppCompatActivity() {
    @Inject lateinit var settingsRepo: SettingsRepo
    private val main = MainFragment()
    private val settings = SettingsFragment()
    private val lab = LabFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.mainPhones.setOnClickListener { setPage(main) }
        binding.mainSettings.setOnClickListener { setPage(settings) }
        binding.mainLaba4.setOnClickListener { setPage(lab) }
        setPage(main)
        navigate(MainFragment.MainSection.Brands)
        (applicationContext as App).appComponent.inject(this)
        AppCompatDelegate.setDefaultNightMode(
            if (settingsRepo.isNightMode()) AppCompatDelegate.MODE_NIGHT_YES
            else AppCompatDelegate.MODE_NIGHT_NO
        )
    }

    private fun setPage(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main_screen, fragment)
            .commit()
    }

    private fun navigate(section: MainFragment.MainSection, brand: BrandInfo? = null, phone: PhoneInfo? = null) {
        main.navigate(section, brand, phone)
    }

    companion object {
        fun Fragment.navigate(
            section: MainFragment.MainSection,
            brand: BrandInfo? = null,
            phone: PhoneInfo? = null,
        ) {
            (requireActivity() as MainActivity).navigate(section, brand, phone)
        }
    }
}
