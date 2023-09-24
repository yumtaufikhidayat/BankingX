package com.taufik.bankingx.data.source

import com.taufik.bankingx.data.local.BankingXDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val dao: BankingXDao
) {
    suspend fun insertWallets() = dao.insertWallet(DummyData.listOfWallets())

    fun getAllWallets() = dao.getAllWallets()
}