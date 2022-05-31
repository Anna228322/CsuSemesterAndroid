package com.example.csusemesterandroid.ui.recyclerview.models

import com.example.csusemesterandroid.domain.models.BrandInfo

data class BrandItem(
    val index: Int,
    val brandInfo: BrandInfo,
    val click: () -> Unit,
)