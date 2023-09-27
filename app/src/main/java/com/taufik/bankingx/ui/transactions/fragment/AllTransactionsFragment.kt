package com.taufik.bankingx.ui.transactions.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.bankingx.databinding.FragmentAllTransactionsBinding
import com.taufik.bankingx.ui.transactions.adapter.AllTransactionsAdapter
import com.taufik.bankingx.ui.transactions.viewmodel.TransactionsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllTransactionsFragment : Fragment() {

    private var _binding: FragmentAllTransactionsBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<TransactionsViewModel>()
    private val allTransactionsAdapter by lazy { AllTransactionsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAllTransactionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        showAllTransactionsObserver()
    }

    private fun initAdapter() {
        binding.rvAllTransactions.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = allTransactionsAdapter
        }
    }

    private fun showAllTransactionsObserver() {
        viewModel.getAllTransactions().observe(viewLifecycleOwner) {
            allTransactionsAdapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}