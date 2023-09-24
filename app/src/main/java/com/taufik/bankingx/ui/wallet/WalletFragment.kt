package com.taufik.bankingx.ui.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.bankingx.R
import com.taufik.bankingx.databinding.FragmentWalletBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WalletFragment : Fragment() {

    private var _binding: FragmentWalletBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<WalletViewModel>()
    private val walletAdapter by lazy { WalletAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWalletBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setHeaderTitle()
        initAdapter()
        getAllWallets()
    }

    private fun setHeaderTitle() {
        binding.toolbarWallet.tvTitle.text = getString(R.string.txt_wallet)
    }

    private fun initAdapter() {
        binding.rvWallet.apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
            adapter = walletAdapter
        }
    }

    private fun getAllWallets() {
        lifecycleScope.launch {
            viewModel.getAllWallets().observe(viewLifecycleOwner) {
                walletAdapter.submitList(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}