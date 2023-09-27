package com.taufik.bankingx.model.home

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Home(
    @PrimaryKey
    val id: Int,
    val resourceImage: Int,
    val backgroundColor: Int,
    val name: String
)