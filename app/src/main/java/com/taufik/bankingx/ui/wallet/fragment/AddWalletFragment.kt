package com.taufik.bankingx.ui.wallet.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.bankingx.R
import com.taufik.bankingx.databinding.FragmentAddWalletBinding
import com.taufik.bankingx.ui.wallet.adapter.AddWalletAdapter
import com.taufik.bankingx.ui.wallet.viewmodel.AddWalletViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddWalletFragment : Fragment() {

    private var _binding: FragmentAddWalletBinding? = null
    private val binding get() = _binding!!
    
    private val addWalletAdapter by lazy { AddWalletAdapter { id ->
        setSkinWallet(id)
    }}
    private val viewModel by viewModels<AddWalletViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddWalletBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        addWalletSkinObserver()
        inputCardName()
        inputCardNumber()
        inputExpiryCard()
    }

    private fun initToolbar() {
        binding.toolbarAddWallet.apply {
            tvTitle.text = getString(R.string.txt_add_wallet)
            imgFilter.isVisible = false
            imgBack.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun initAdapter() {
        binding.rvWalletSkin.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            setHasFixedSize(true)
            adapter = addWalletAdapter
        }
    }

    private fun addWalletSkinObserver() {
        viewModel.getAllWalletSkins().observe(viewLifecycleOwner) {
            addWalletAdapter.submitList(it)
            initAdapter()
        }
    }

    private fun setSkinWallet(id: Int) {
        binding.backgroundAddWallet.cardWallet.apply {
            when (id) {
                0 -> setBackgroundResource(R.drawable.bg_card_skin_1)
                1 -> setBackgroundResource(R.drawable.bg_card_skin_2)
                2 -> setBackgroundResource(R.drawable.bg_card_skin_3)
            }
        }
    }

    private fun inputCardName() {
        binding.apply {
            tieCardName.addTextChangedListener(afterTextChanged = { s->
                backgroundAddWallet.tvCCCardName.text = s.toString()
            })
        }
    }

    private fun inputCardNumber() {
        binding.apply {
            tieCardNumber.addTextChangedListener(afterTextChanged = { s ->
                val initial = s.toString()
                var processed = initial.replace("\\D".toRegex(), "-")
                processed = processed.replace("(\\d{4})(?=\\d)".toRegex(), "$1 ")
                if (initial != processed) {
                    s?.replace(0, initial.length, processed)
                }
                backgroundAddWallet.tvCCNumber.text = processed
            })
        }
    }

    private fun inputExpiryCard() {
        binding.tieExpiredDate.addTextChangedListener(afterTextChanged = { s ->
            var lock = false
            s?.let {
                if (lock || s.length > 16) {
                    return@let
                }
                lock = true
                run {
                    var i = 4
                    while (i < s.length) {
                        if (s.toString()[i] !== ' ') {
                            s.insert(i, " ")
                        }
                        i += 5
                    }
                }
                lock = false
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}