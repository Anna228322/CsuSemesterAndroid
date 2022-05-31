package com.example.csusemesterandroid.ui.recyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.csusemesterandroid.databinding.ItemPhoneBinding
import com.example.csusemesterandroid.ui.recyclerview.ItemCallback
import com.example.csusemesterandroid.ui.recyclerview.models.PhoneItem
import com.example.csusemesterandroid.ui.recyclerview.viewholders.PhoneItemViewHolder

class PhonesAdapter: ListAdapter<PhoneItem, PhoneItemViewHolder>(ItemCallback<PhoneItem>()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneItemViewHolder {
        return PhoneItemViewHolder(ItemPhoneBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PhoneItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}