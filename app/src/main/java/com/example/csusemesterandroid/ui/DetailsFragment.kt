package com.example.csusemesterandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.csusemesterandroid.App.Companion.viewModelFactory
import com.example.csusemesterandroid.databinding.FragmentDetailsBinding
import com.example.csusemesterandroid.domain.models.PhoneInfo
import com.example.csusemesterandroid.ui.MainActivity.Companion.navigate
import com.example.csusemesterandroid.ui.recyclerview.adapters.ImagesAdapter
import com.example.csusemesterandroid.ui.viewmodel.DetailsViewModel

class DetailsFragment(
    private val phone: PhoneInfo
): Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private val viewModel by viewModels<DetailsViewModel> { viewModelFactory() }
    private val adapter = ImagesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.retry.setOnClickListener {
            viewModel.load(phone)
        }
        binding.back.setOnClickListener { navigate(MainFragment.MainSection.Phones) }
        viewModel.item.observe(viewLifecycleOwner) { item ->
            binding.retry.isVisible = item == null
            adapter.submitList(item?.images?.toList() ?: emptyList())
            binding.brand.text = "Бренд: " + item?.brand ?: ""
            binding.name.text = "Модель: " + item?.name ?: ""
            binding.date.text = "Релиз: " + item?.date ?: ""
            binding.os.text = "ОС: " + item?.os ?: ""
            binding.storage.text = "Память: " + item?.storage ?: ""
            binding.dimension.text = "Размеры: " + item?.dimension ?: ""
        }
        viewModel.loading.observe(viewLifecycleOwner) { loading ->
            binding.pb.isVisible = loading
            binding.retry.isVisible = false
        }
        viewModel.error.observe(viewLifecycleOwner) { error ->
            if (error.isNotEmpty()) {
                Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.load(phone)
    }

    override fun onPause() {
        super.onPause()
        viewModel.stop()
    }
}