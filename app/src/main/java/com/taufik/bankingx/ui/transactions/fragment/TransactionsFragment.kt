package com.taufik.bankingx.ui.transactions.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayoutMediator
import com.taufik.bankingx.R
import com.taufik.bankingx.databinding.FragmentTransactionsBinding
import com.taufik.bankingx.ui.activity.adapter.PagerActivityAdapter
import com.taufik.bankingx.ui.activity.fragment.ExpensesActivityFragment
import com.taufik.bankingx.ui.activity.fragment.IncomeActivityFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionsFragment : Fragment() {

    private var _binding: FragmentTransactionsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransactionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbarHeader()
        setAllTransactionsTabLayout()
    }

    private fun initToolbarHeader() {
        binding.toolbarTransactions.apply {
            tvTitle.text = getString(R.string.txt_transactions)
            imgFilter.isVisible = true
            imgFilter.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ic_filter))
            imgBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun setAllTransactionsTabLayout() {
        binding.apply {
            val fragmentsList = mutableListOf(
                AllTransactionsFragment(),
                ExpensesActivityFragment(),
                IncomeActivityFragment()
            )

            val pagerAllActivityAdapter = PagerActivityAdapter(
                listOfFragments = fragmentsList,
                fragment = this@TransactionsFragment
            )
            vpTransactions.adapter = pagerAllActivityAdapter
            TabLayoutMediator(tabTransactions, vpTransactions) { tabs, position ->
                tabs.text = getString(tabsAllTransactionsTitle[position])
            }.attach()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private val tabsAllTransactionsTitle = intArrayOf(
            R.string.txt_all,
            R.string.txt_expenses,
            R.string.txt_income
        )
    }
}