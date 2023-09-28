package com.taufik.bankingx.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.taufik.bankingx.model.activity.AllActivity
import com.taufik.bankingx.model.home.Home
import com.taufik.bankingx.model.transactions.AllTransactions
import com.taufik.bankingx.model.wallet.AddWallet
import com.taufik.bankingx.model.wallet.Wallet

@Database(
    entities = [
        Wallet::class,
        AllActivity::class,
        Home::class,
        AllTransactions::class,
        AddWallet::class
    ],
    version = 1,
    exportSchema = false
)
abstract class BankingXDatabase : RoomDatabase() {
    abstract fun getBankingXDao(): BankingXDao
}