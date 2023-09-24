package com.taufik.bankingx.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.taufik.bankingx.model.wallet.Wallet

@Dao
interface BankingXDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWallet(listOfWallets: List<Wallet>)

    @Query("SELECT * FROM wallet")
    fun getAllWallets(): LiveData<List<Wallet>>
}