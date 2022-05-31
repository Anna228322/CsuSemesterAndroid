package com.example.csusemesterandroid.ui.recyclerview.viewholders

import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.csusemesterandroid.R
import com.example.csusemesterandroid.databinding.ItemImageBinding

class ImageItemViewHolder(
    private val binding: ItemImageBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(url: String) {
        Glide.with(binding.root.context)
            .load(url)
            .placeholder(ResourcesCompat.getDrawable(binding.root.resources, R.drawable.ic_phone, null))
            .apply(RequestOptions().centerCrop())
            .into(binding.image)
    }
}