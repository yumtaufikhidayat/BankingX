package com.taufik.bankingx.ui.activity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.bankingx.databinding.FragmentAllActivityBinding
import com.taufik.bankingx.ui.activity.adapter.AllActivityAdapter
import com.taufik.bankingx.ui.activity.viewmodel.AllActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AllActivityFragment : Fragment() {

    private var _binding: FragmentAllActivityBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<AllActivityViewModel>()
    private val allActivityAdapter by lazy { AllActivityAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllActivityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        getAllActivityObserver()
    }

    private fun initAdapter() {
        binding.rvAllActivity.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = allActivityAdapter
        }
    }

    private fun getAllActivityObserver() {
        viewModel.getAllActivities().observe(viewLifecycleOwner) {
            allActivityAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}