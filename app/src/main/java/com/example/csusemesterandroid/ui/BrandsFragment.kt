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
import com.example.csusemesterandroid.databinding.FragmentBrandsBinding
import com.example.csusemesterandroid.ui.MainActivity.Companion.navigate
import com.example.csusemesterandroid.ui.recyclerview.adapters.BrandsAdapter
import com.example.csusemesterandroid.ui.viewmodel.BrandsViewModel

class BrandsFragment: Fragment() {
    private lateinit var binding: FragmentBrandsBinding
    private val viewModel by viewModels<BrandsViewModel> { viewModelFactory() }
    private val adapter = BrandsAdapter()
    private var navigate = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBrandsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rv.adapter = adapter
        binding.rv.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.retry.setOnClickListener { viewModel.setList() }
        viewModel.items.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list.toList())
            binding.retry.isVisible = list.isEmpty()
        }
        viewModel.loading.observe(viewLifecycleOwner) { loading ->
            binding.pb.visibility = if (loading) View.VISIBLE else View.INVISIBLE
            binding.retry.isVisible = false
        }
        viewModel.error.observe(viewLifecycleOwner) { error ->
            if (error.isNotEmpty()) {
                Toast.makeText(requireContext(), error, Toast.LENGTH_LONG).show()
            }
        }
        viewModel.chosenBrand.observe(viewLifecycleOwner) { brand ->
            if (brand != null && navigate) {
                navigate(MainFragment.MainSection.Phones, brand)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        navigate = true
        viewModel.setList()
    }

    override fun onPause() {
        super.onPause()
        navigate = false
        viewModel.stop()
        adapter.submitList(emptyList())
    }
}