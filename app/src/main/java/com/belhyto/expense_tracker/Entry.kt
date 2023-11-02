package com.belhyto.expense_tracker

data class Entry(
    val id: Int,
    val description: String,
    val amount: Double,
    val type: String
)
