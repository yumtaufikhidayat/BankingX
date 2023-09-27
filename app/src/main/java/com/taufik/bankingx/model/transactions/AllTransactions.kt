package com.taufik.bankingx.model.transactions

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AllTransactions(
    @PrimaryKey
    val transactionsId: Int,
    val profileImage: Int,
    val profileName: String,
    val transactionsStatus: String,
    val transactionsBalance: String,
    val transactionsTimestamp: String,
    val backgroundColor: Int
)
