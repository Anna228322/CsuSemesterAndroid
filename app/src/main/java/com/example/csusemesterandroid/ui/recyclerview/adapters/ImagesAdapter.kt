package com.example.csusemesterandroid.ui.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.csusemesterandroid.databinding.ItemImageBinding
import com.example.csusemesterandroid.ui.recyclerview.ItemCallback
import com.example.csusemesterandroid.ui.recyclerview.viewholders.ImageItemViewHolder

class ImagesAdapter: ListAdapter<String, ImageItemViewHolder>(ItemCallback<String>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageItemViewHolder {
        return ImageItemViewHolder(ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ImageItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}