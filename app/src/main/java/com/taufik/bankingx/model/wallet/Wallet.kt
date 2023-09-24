package com.taufik.bankingx.model.wallet

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Wallet(
    @PrimaryKey
    val walletId: Int,
    val walletName: String,
    val walletBalance: String,
    val walletLogo: Int,
    val walletColor: Int
)
