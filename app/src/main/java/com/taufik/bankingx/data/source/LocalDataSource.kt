package com.taufik.bankingx.data.source

import com.taufik.bankingx.data.local.BankingXDao
import javax.inject.Inject

class LocalDataSource @Inject constructor(
    private val dao: BankingXDao
) {
    fun insertWallets() = dao.insertWallet(DummyData.listOfWallets())

    fun getAllWallets() = dao.getAllWallets()

    fun insertAllActivity() = dao.insertAllActivity(DummyData.listOfAllActivities())

    fun getAllActivities() = dao.getAllActivities()

    fun getAllChartDataset() = DummyData.getLineDataSet()

    fun insertAllHomeMenu() = dao.insertAllHomeMenu(DummyData.getHomeList())

    fun getAllHomeMenu() = dao.getAllHomeMenu()

    fun insertAllTransactions() = dao.insertAllTransactions(DummyData.getAllTransactions())

    fun getAllTransactions() = dao.getAllTransactions()
}