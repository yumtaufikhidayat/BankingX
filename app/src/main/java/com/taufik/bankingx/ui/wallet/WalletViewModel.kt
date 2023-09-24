package com.taufik.bankingx.ui.wallet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taufik.bankingx.data.repository.BankingXRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WalletViewModel @Inject constructor(
    private val repository: BankingXRepository
) : ViewModel() {

    init {
        insertWallets()
    }

    private fun insertWallets() = viewModelScope.launch {
        repository.insertWallets()
    }

    fun getAllWallets() = repository.getAllWallets()
}