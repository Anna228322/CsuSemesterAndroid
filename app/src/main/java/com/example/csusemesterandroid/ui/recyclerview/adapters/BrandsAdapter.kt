package com.example.csusemesterandroid.ui.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.csusemesterandroid.databinding.ItemBrandBinding
import com.example.csusemesterandroid.ui.recyclerview.ItemCallback
import com.example.csusemesterandroid.ui.recyclerview.models.BrandItem
import com.example.csusemesterandroid.ui.recyclerview.viewholders.BrandItemViewHolder

class BrandsAdapter: ListAdapter<BrandItem, BrandItemViewHolder>(ItemCallback<BrandItem>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrandItemViewHolder {
        return BrandItemViewHolder(ItemBrandBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: BrandItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}