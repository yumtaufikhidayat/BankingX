package com.taufik.bankingx.ui.activity.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.taufik.bankingx.R
import com.taufik.bankingx.databinding.FragmentActivityBinding
import com.taufik.bankingx.ui.activity.adapter.PagerActivityAdapter
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
        setActivityTabLayout()
        setAllActivityTabLayout()
    }

    private fun initToolbarHeader() {
        binding.toolbarActivity.tvTitle.text = getString(R.string.txt_activity)
    }

    private fun setActivityTabLayout() {
        binding.apply {
            val fragmentsList = mutableListOf(
                WeekActivityFragment(),
                MonthActivityFragment(),
                YearActivityFragment()
            )

            val pagerActivityAdapter = PagerActivityAdapter(
                listOfFragments = fragmentsList,
                fragment = this@ActivityFragment
            )
            vpActivity.adapter = pagerActivityAdapter
            TabLayoutMediator(tabActivity, vpActivity) { tabs, position ->
                tabs.text = getString(tabsActivityTitle[position])
            }.attach()
        }
    }

    private fun setAllActivityTabLayout() {
        binding.apply {
            val fragmentsList = mutableListOf(
                AllActivityFragment(),
                ExpensesActivityFragment(),
                IncomeActivityFragment()
            )

            val pagerAllActivityAdapter = PagerActivityAdapter(
                listOfFragments = fragmentsList,
                fragment = this@ActivityFragment
            )
            vpAllActivity.adapter = pagerAllActivityAdapter
            TabLayoutMediator(tabAllActivity, vpAllActivity) { tabs, position ->
                tabs.text = getString(tabsAllActivityTitle[position])
            }.attach()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private val tabsActivityTitle = intArrayOf(
            R.string.txt_week,
            R.string.txt_month,
            R.string.txt_year
        )

        private val tabsAllActivityTitle = intArrayOf(
            R.string.txt_all,
            R.string.txt_expenses,
            R.string.txt_income
        )
    }
}