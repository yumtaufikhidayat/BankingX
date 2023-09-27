package com.taufik.bankingx.ui.transactions.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taufik.bankingx.data.repository.BankingXRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionsViewModel @Inject constructor(
    private val repository: BankingXRepository
) : ViewModel() {

    init {
        insertAllTransactions()
    }

    private fun insertAllTransactions() = viewModelScope.launch {
        repository.insertAllTransactions()
    }

    fun getAllTransactions() = repository.getAllTransactions()
}