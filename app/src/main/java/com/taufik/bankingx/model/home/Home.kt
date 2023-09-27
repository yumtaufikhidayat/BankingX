package com.taufik.bankingx.model.home

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Home(
    @PrimaryKey
    val id: Int,
    val resource: Int,
    val name: String
)