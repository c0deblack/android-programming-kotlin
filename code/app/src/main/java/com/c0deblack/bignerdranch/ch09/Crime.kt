package com.c0deblack.bignerdranch.ch09

import java.util.UUID
import java.util.Date

/***************************************************************************************************
 * Data class used to represent a single crime object.
 **************************************************************************************************/
data class Crime(
    val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean
)