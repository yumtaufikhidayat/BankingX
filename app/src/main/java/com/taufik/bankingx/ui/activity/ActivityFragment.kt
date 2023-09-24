package com.taufik.bankingx.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.taufik.bankingx.R
import com.taufik.bankingx.databinding.FragmentActivityBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityFragment : Fragment() {

    private var _binding: FragmentActivityBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initToolbarHeader()
    }

    private fun initToolbarHeader() {
        binding.toolbarActivity.tvTitle.text = getString(R.string.txt_activity)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}