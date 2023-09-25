package com.taufik.bankingx.ui.activity.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerActivityAdapter(
    private val listOfFragments: MutableList<Fragment>,
    fragment: Fragment
): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = listOfFragments.size

    override fun createFragment(position: Int): Fragment = listOfFragments[position]
}