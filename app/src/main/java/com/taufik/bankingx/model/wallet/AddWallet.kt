package com.taufik.bankingx.model.wallet

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AddWallet(
    @PrimaryKey
    val id: Int,
    val backgroundResource: Int
)
