package com.example.csusemesterandroid.ui.recyclerview.models

import com.example.csusemesterandroid.domain.models.PhoneInfo

data class PhoneItem(
    val index: Int,
    val phoneInfo: PhoneInfo,
    val click: () -> Unit
)
