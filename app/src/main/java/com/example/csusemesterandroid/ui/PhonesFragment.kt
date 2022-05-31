package com.example.csusemesterandroid.ui

import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.csusemesterandroid.App.Companion.viewModelFactory
import com.example.csusemesterandroid.databinding.FragmentPhonesBinding
import com.example.csusemesterandroid.domain.models.BrandInfo
import com.example.csusemesterandroid.ui.MainActivity.Companion.navigate
import com.example.csusemesterandroid.ui.recyclerview.adapters.PhonesAdapter
import com.example.csusemesterandroid.ui.viewmodel.PhonesViewModel
import com.google.android.flexbox.*

class PhonesFragment(
    private val brand: BrandInfo
): Fragment() {
    private lateinit var binding: FragmentPhonesBinding
    private val viewModel by viewModels<PhonesViewModel> { viewModelFactory() }
    private val adapter = PhonesAdapter()
    private var navigate = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhonesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.adapter = adapter
        binding.rv.layoutManager = FlexboxLayoutManager(requireContext()).apply {
            flexDirection = FlexDirection.COLUMN
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
        }
        binding.retry.setOnClickListener {
            viewModel.loadPhones(brand)
        }
        binding.back.setOnClickListener { navigate(MainFragment.MainSection.Brands) }
        binding.search.addTextChangedListener {
            if (it == null) return@addTextChangedListener
            viewModel.search(it.toString())
        }
        viewModel.items.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list.toList())
            binding.retry.isVisible = list.isEmpty()
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
        viewModel.chosenPhone.observe(viewLifecycleOwner) { phone ->
            if (phone != null && navigate) {
                navigate(MainFragment.MainSection.Details, brand, phone)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        navigate = true
        viewModel.loadPhones(brand)
    }

    override fun onPause() {
        super.onPause()
        navigate = false
        viewModel.stop()
        adapter.submitList(emptyList())
    }
}