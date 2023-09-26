package com.taufik.bankingx.data.source

import com.taufik.bankingx.R
import com.taufik.bankingx.model.activity.AllActivity
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

    fun listOfAllActivities(): ArrayList<AllActivity> {
        val list = ArrayList<AllActivity>()
        list.add(
            AllActivity(
                activityId = 1,
                profileImage = R.drawable.profile1,
                profileName = "Olivia Johanson",
                activityStatus = "Transfer",
                activityBalance = "-\$432.9",
                activityTimestamp = "3.30 AM"
            )
        )

        list.add(
            AllActivity(
                activityId = 2,
                profileImage = R.drawable.profile2,
                profileName = "James O'Coner",
                activityStatus = "Transfer",
                activityBalance = "-\$40",
                activityTimestamp = "1w ago"
            )
        )

        list.add(
            AllActivity(
                activityId = 3,
                profileImage = R.drawable.profile3,
                profileName = "David Marpaung",
                activityStatus = "Transfer",
                activityBalance = "-\$29.4",
                activityTimestamp = "4d ago"
            )
        )
        return list
    }
}