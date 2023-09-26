package com.taufik.bankingx.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.taufik.bankingx.model.activity.AllActivity
import com.taufik.bankingx.model.wallet.Wallet

@Database(
    entities = [
        Wallet::class,
        AllActivity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class BankingXDatabase : RoomDatabase() {
    abstract fun getBankingXDao(): BankingXDao
}