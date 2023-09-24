package com.taufik.bankingx.data.repository

import com.taufik.bankingx.data.source.LocalDataSource
import javax.inject.Inject

class BankingXRepository @Inject constructor(
    private val localDataSource: LocalDataSource
) {
    suspend fun insertWallets() = localDataSource.insertWallets()

    fun getAllWallets() = localDataSource.getAllWallets()
}