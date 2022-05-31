package com.example.csusemesterandroid.ui.recyclerview.viewholders

import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.csusemesterandroid.R
import com.example.csusemesterandroid.databinding.ItemPhoneBinding
import com.example.csusemesterandroid.ui.recyclerview.models.PhoneItem

class PhoneItemViewHolder(
    private val binding: ItemPhoneBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: PhoneItem) {
        binding.name.text = item.phoneInfo.name
        Glide.with(binding.root.context)
            .load(item.phoneInfo.image)
            .placeholder(ResourcesCompat.getDrawable(binding.root.resources, R.drawable.ic_phone, null))
            .apply(RequestOptions().centerCrop())
            .into(binding.image)
        binding.root.setOnClickListener { item.click() }
    }
}