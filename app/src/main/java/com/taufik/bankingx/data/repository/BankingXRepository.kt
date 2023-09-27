package com.taufik.bankingx.data.repository

import com.taufik.bankingx.data.source.LocalDataSource
import javax.inject.Inject

class BankingXRepository @Inject constructor(
    private val localDataSource: LocalDataSource
) {
    fun insertWallets() = localDataSource.insertWallets()

    fun getAllWallets() = localDataSource.getAllWallets()

    fun insertAllActivity() = localDataSource.insertAllActivity()

    fun getAllActivities() = localDataSource.getAllActivities()

    fun getAllChartDataset() = localDataSource.getAllChartDataset()

    fun insertAllHomeMenu() = localDataSource.insertAllHomeMenu()

    fun getAllHomeMenu() = localDataSource.getAllHomeMenu()

    fun insertAllTransactions() = localDataSource.insertAllTransactions()

    fun getAllTransactions() = localDataSource.getAllTransactions()
}