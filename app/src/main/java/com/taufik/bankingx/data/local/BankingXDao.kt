package com.taufik.bankingx.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.taufik.bankingx.model.activity.AllActivity
import com.taufik.bankingx.model.home.Home
import com.taufik.bankingx.model.transactions.AllTransactions
import com.taufik.bankingx.model.wallet.AddWallet
import com.taufik.bankingx.model.wallet.Wallet

@Dao
interface BankingXDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWallet(listOfWallets: List<Wallet>)

    @Query("SELECT * FROM wallet")
    fun getAllWallets(): LiveData<List<Wallet>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllActivity(listOfActivities: List<AllActivity>)

    @Query("SELECT * FROM allactivity")
    fun getAllActivities(): LiveData<List<AllActivity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllHomeMenu(listOfHomeMenu: List<Home>)

    @Query("SELECT * FROM home")
    fun getAllHomeMenu(): LiveData<List<Home>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTransactions(listOfAllTransactions: List<AllTransactions>)

    @Query("SELECT * FROM alltransactions")
    fun getAllTransactions(): LiveData<List<AllTransactions>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllWalletSkins(listOfAllWalletSkins: List<AddWallet>)

    @Query("SELECT * FROM addwallet")
    fun getAllWalletSkins(): LiveData<List<AddWallet>>
}