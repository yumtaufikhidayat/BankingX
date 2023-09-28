package com.taufik.bankingx.ui.wallet.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taufik.bankingx.data.repository.BankingXRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddWalletViewModel @Inject constructor(
    private val repository: BankingXRepository
) : ViewModel() {

    init {
        insertAllWalletSkins()
    }

    private fun insertAllWalletSkins() = viewModelScope.launch {
        repository.insertAllWalletSkins()
    }

    fun getAllWalletSkins() = repository.getAllWalletSkins()
}