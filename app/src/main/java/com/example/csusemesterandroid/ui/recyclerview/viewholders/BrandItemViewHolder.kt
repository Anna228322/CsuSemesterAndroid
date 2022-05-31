package com.example.csusemesterandroid.ui.recyclerview.viewholders

import androidx.recyclerview.widget.RecyclerView
import com.example.csusemesterandroid.databinding.ItemBrandBinding
import com.example.csusemesterandroid.ui.recyclerview.models.BrandItem

class BrandItemViewHolder(
    private val binding: ItemBrandBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: BrandItem) {
        binding.number.text = (item.index + 1).toString() + "."
        binding.name.text = item.brandInfo.name
        binding.count.text = "Devices amount: ${item.brandInfo.count}"
        binding.root.setOnClickListener { item.click() }
    }
}