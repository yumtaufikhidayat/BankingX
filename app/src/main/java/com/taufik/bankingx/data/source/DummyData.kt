package com.taufik.bankingx.data.source

import com.taufik.bankingx.R
import com.taufik.bankingx.model.wallet.Wallet

object DummyData {
    fun listOfWallets(): ArrayList<Wallet> {
        val list = ArrayList<Wallet>()
        list.add(
            Wallet(
                walletId = 1,
                walletName = "Main Wallet",
                walletBalance = "\$45.500,12",
                walletLogo = R.drawable.logo_card_1,
                walletColor = R.drawable.bg_card_1
            )
        )
        list.add(
            Wallet(
                walletId = 2,
                walletName = "XYZ Wallet",
                walletBalance = "\$250,5",
                walletLogo = R.drawable.logo_card_2,
                walletColor = R.drawable.bg_card_2
            )
        )
        list.add(
            Wallet(
                walletId = 3,
                walletName = "ABC Wallet",
                walletBalance = "\$4.550,67",
                walletLogo = R.drawable.logo_card_3,
                walletColor = R.drawable.bg_card_3
            )
        )
        return list
    }
}