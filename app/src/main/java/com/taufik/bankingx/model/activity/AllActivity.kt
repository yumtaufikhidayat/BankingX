package com.taufik.bankingx.model.activity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AllActivity(
    @PrimaryKey
    val activityId: Int,
    val profileImage: Int,
    val profileName: String,
    val activityStatus: String,
    val activityBalance: String,
    val activityTimestamp: String
)
