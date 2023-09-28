package com.taufik.bankingx.data.source

import com.github.mikephil.charting.data.Entry
import com.taufik.bankingx.R
import com.taufik.bankingx.model.activity.AllActivity
import com.taufik.bankingx.model.home.Home
import com.taufik.bankingx.model.transactions.AllTransactions
import com.taufik.bankingx.model.wallet.AddWallet
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

    fun getLineDataSet(): ArrayList<Entry> {
        val lineValues: ArrayList<Entry> = arrayListOf()
        lineValues.apply {
            add(Entry(10f, 1F))
            add(Entry(20f, 4F))
            add(Entry(30f, 3F))
            add(Entry(40f, 4F))
            add(Entry(50f, 2F))
            add(Entry(60f, 4F))
            add(Entry(70f, 6F))
            add(Entry(80f, 5F))
            add(Entry(90f, 5F))
            add(Entry(100f, 7F))
            add(Entry(110f, 8F))
            add(Entry(120f, 6F))
        }
        return lineValues
    }

    fun getHomeList(): ArrayList<Home> {
        val homeList: ArrayList<Home> = arrayListOf()
        homeList.apply {
            add(
                Home(
                    id = 1,
                    resourceImage = R.drawable.ic_add_card,
                    name = "Add Wallet",
                    backgroundColor = R.color.green_200
                )
            )
            add(
                Home(
                    id = 2,
                    resourceImage = R.drawable.ic_statement,
                    name = "Statement",
                    backgroundColor = R.color.lavender_200
                )
            )
            add(
                Home(
                    id = 3,
                    resourceImage = R.drawable.ic_transactions,
                    name = "Transactions",
                    backgroundColor = R.color.magenta_100
                )
            )
        }
        return homeList
    }

    fun getAllTransactions(): ArrayList<AllTransactions> {
        val allTransactionsList :ArrayList<AllTransactions> = arrayListOf()
        allTransactionsList.apply {
            add(
                AllTransactions(
                    transactionsId = 1,
                    profileImage = R.drawable.bank_logo_1,
                    profileName = "Green Bank",
                    transactionsStatus = "Withdraw",
                    transactionsBalance = "\$800",
                    transactionsTimestamp = "4d ago",
                    backgroundColor = R.color.green_400
                )
            )
            add(
                AllTransactions(
                    transactionsId = 2,
                    profileImage = R.drawable.bank_logo_2,
                    profileName = "Legendary Bank",
                    transactionsStatus = "Top Up",
                    transactionsBalance = "-\$1,000",
                    transactionsTimestamp = "1w ago",
                    backgroundColor = R.color.black_100
                )
            )
            add(
                AllTransactions(
                    transactionsId = 3,
                    profileImage = R.drawable.bank_logo_3,
                    profileName = "Bitkoin",
                    transactionsStatus = "SELL",
                    transactionsBalance = "-\$540",
                    transactionsTimestamp = "1w ago",
                    backgroundColor = R.color.orange_100
                )
            )
            add(
                AllTransactions(
                    transactionsId = 4,
                    profileImage = R.drawable.bank_logo_4,
                    profileName = "Kaya Bank",
                    transactionsStatus = "Top Up",
                    transactionsBalance = "\$850",
                    transactionsTimestamp = "4d ago",
                    backgroundColor = R.color.white_100
                )
            )
            add(
                AllTransactions(
                    transactionsId = 5,
                    profileImage = R.drawable.profile1,
                    profileName = "Olivia Johanson",
                    transactionsStatus = "Transfer",
                    transactionsBalance = "\$432.9",
                    transactionsTimestamp = "3.30 AM",
                    backgroundColor = R.color.white_200
                )
            )
            add(
                AllTransactions(
                    transactionsId = 6,
                    profileImage = R.drawable.bank_logo_5,
                    profileName = "Purple Bank",
                    transactionsStatus = "Withdraw",
                    transactionsBalance = "\$800",
                    transactionsTimestamp = "4d ago",
                    backgroundColor = R.color.magenta_300
                )
            )
            add(
                AllTransactions(
                    transactionsId = 7,
                    profileImage = R.drawable.bank_logo_2,
                    profileName = "Legendary Bank",
                    transactionsStatus = "Top Up",
                    transactionsBalance = "-\$1,000",
                    transactionsTimestamp = "1w ago",
                    backgroundColor = R.color.black_100
                )
            )
        }
        return allTransactionsList
    }

    fun getAllWalletSkins(): ArrayList<AddWallet> {
        val listSkins = ArrayList<AddWallet>()
        listSkins.add(AddWallet(id = 1, backgroundResource = R.drawable.bg_card_skin_1))
        listSkins.add(AddWallet(id = 2, backgroundResource = R.drawable.bg_card_skin_2))
        listSkins.add(AddWallet(id = 3, backgroundResource = R.drawable.bg_card_skin_3))
        return listSkins
    }
}