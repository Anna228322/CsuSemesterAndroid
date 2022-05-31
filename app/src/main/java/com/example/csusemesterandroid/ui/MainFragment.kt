package com.example.csusemesterandroid.ui

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.example.csusemesterandroid.R
import com.example.csusemesterandroid.domain.models.BrandInfo
import com.example.csusemesterandroid.domain.models.PhoneInfo

class MainFragment: Fragment(R.layout.fragment_main) {
    private var section = MainSection.Brands
    private var brand: BrandInfo? = null
    private var phone: PhoneInfo? = null

    override fun onResume() {
        super.onResume()
        navigate(section, brand, phone)
    }

    fun navigate(section: MainSection, newBrand: BrandInfo? = null, newPhone: PhoneInfo? = null) {
        if (newBrand != null) brand = newBrand
        if (newPhone != null) phone = newPhone
        val page = when(section) {
            MainSection.Brands -> BrandsFragment()
            MainSection.Phones -> PhonesFragment(brand!!)
            MainSection.Details -> DetailsFragment(phone!!)
        }
        this.section = section
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_main, page)
                .commit()
        }
    }

    enum class MainSection {
        Brands, Phones, Details
    }
}