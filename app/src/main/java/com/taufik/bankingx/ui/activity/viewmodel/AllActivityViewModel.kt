package com.taufik.bankingx.ui.activity.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.taufik.bankingx.data.repository.BankingXRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllActivityViewModel @Inject constructor(
    private val repository: BankingXRepository
) : ViewModel() {

    init {
        insertAllActivity()
    }

    private fun insertAllActivity() = viewModelScope.launch {
        repository.insertAllActivity()
    }

    fun getAllActivities() = repository.getAllActivities()
}