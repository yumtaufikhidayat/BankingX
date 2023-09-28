package com.taufik.bankingx.ui.home.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.bankingx.R
import com.taufik.bankingx.databinding.FragmentHomeBinding
import com.taufik.bankingx.ui.home.adapter.HomeAdapter
import com.taufik.bankingx.ui.home.viewmodel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<HomeViewModel>()
    private val homeAdapter by lazy { HomeAdapter {
        when (it) {
            0 -> navigateScreen(R.id.addWalletFragment)
            1 -> showAlertDialog()
            2 -> navigateScreen(R.id.transactionsFragment)
        }
    } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initAdapter()
        showHomeMenuObserver()
    }

    private fun initToolbar() {
        binding.toolbarHome.apply {
            tvTitle.text = getString(R.string.txt_home)
            imgFilter.isVisible = false
            imgBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun initAdapter() {
        binding.rvHome.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = homeAdapter
        }
    }

    private fun showHomeMenuObserver() {
        viewModel.getAllHomeMenu().observe(viewLifecycleOwner) {
            homeAdapter.submitList(it)
        }
    }

    private fun navigateScreen(direction: Int) {
        findNavController().navigate(direction)
    }

    private fun showAlertDialog() {
        AlertDialog.Builder(requireContext()).setTitle("Oops!")
            .setMessage("This feature is under development. We will get back soon.")
            .setCancelable(false)
            .setPositiveButton("OK") { dialog, _, ->
            dialog.dismiss()
        }
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}