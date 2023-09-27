package com.taufik.bankingx.ui.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taufik.bankingx.data.repository.BankingXRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: BankingXRepository
) : ViewModel() {

    init {
        insertAllHomeMenu()
    }

    private fun insertAllHomeMenu() = viewModelScope.launch {
        repository.insertAllHomeMenu()
    }

    fun getAllHomeMenu() = repository.getAllHomeMenu()
}