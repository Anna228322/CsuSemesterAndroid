package com.example.csusemesterandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.example.csusemesterandroid.App
import com.example.csusemesterandroid.data.repository.SettingsRepo
import com.example.csusemesterandroid.databinding.FragmentSettingsBinding
import javax.inject.Inject

class SettingsFragment: Fragment() {
    @Inject lateinit var settingsRepo: SettingsRepo
    private lateinit var binding: FragmentSettingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireContext().applicationContext as App).appComponent.inject(this)
        update()
    }

    private fun update() {
        val nightMode = settingsRepo.isNightMode()
        val cacheMode = settingsRepo.isDbEnabled()
        binding.nightText.text = if (nightMode) "NightMode: on" else "NightMode: off"
        binding.cacheText.text = if (cacheMode) "Cache: on" else "Cache: off"
        binding.night.isChecked = nightMode
        binding.cache.isChecked = cacheMode
        binding.night.setOnCheckedChangeListener { _, _ ->
            AppCompatDelegate.setDefaultNightMode(
                if (!nightMode) AppCompatDelegate.MODE_NIGHT_YES
                else AppCompatDelegate.MODE_NIGHT_NO
            )
            settingsRepo.switchNightMode()
            update()
        }
        binding.cache.setOnCheckedChangeListener { _, _ ->
            settingsRepo.switchDb()
            update()
        }
    }
}