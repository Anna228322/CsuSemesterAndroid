package com.example.csusemesterandroid.mappers

import com.example.csusemesterandroid.domain.models.BrandInfo
import com.example.csusemesterandroid.domain.models.PhoneInfo
import com.example.csusemesterandroid.ui.recyclerview.models.BrandItem
import com.example.csusemesterandroid.ui.recyclerview.models.PhoneItem
import javax.inject.Inject

class ItemMapper @Inject constructor() {
    fun infoToItem(brandInfo: BrandInfo, index: Int, click: (Int) -> Unit): BrandItem {
        return BrandItem(index, brandInfo) { click(index) }
    }

    fun infoToItem(phoneInfo: PhoneInfo, index: Int, click: (Int) -> Unit): PhoneItem {
        return PhoneItem(index, phoneInfo) { click(index) }
    }
}