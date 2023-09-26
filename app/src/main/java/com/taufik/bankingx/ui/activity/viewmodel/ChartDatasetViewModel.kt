package com.taufik.bankingx.ui.activity.viewmodel

import androidx.lifecycle.ViewModel
import com.taufik.bankingx.data.repository.BankingXRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChartDatasetViewModel @Inject constructor(
    private val repository: BankingXRepository
) : ViewModel() {
    fun getAllChartDataset() = repository.getAllChartDataset()
}