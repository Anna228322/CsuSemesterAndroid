package com.example.csusemesterandroid.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.csusemesterandroid.databinding.FragmentLabsBinding

class LabFragment: Fragment() {
    private lateinit var binding: FragmentLabsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLabsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.open.setOnClickListener {
            val manager = requireContext().packageManager
            try {
                val intent = manager.getLaunchIntentForPackage("package com.example.laba2")
                intent!!.addCategory(Intent.CATEGORY_LAUNCHER)
                requireContext().startActivity(intent)
            } catch (_: Exception) {
                Toast.makeText(requireContext(), "Lab not found", Toast.LENGTH_LONG).show()
            }
        }
    }
}