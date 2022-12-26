package com.c0deblack.bignerdranch.ch12

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import java.util.UUID
import java.util.Date

/***************************************************************************************************
 * Data class used to represent a single crime object.
 **************************************************************************************************/
@Entity
data class Crime(
    @PrimaryKey val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean,
    @Ignore val requiresPolice: Boolean = false
) {
    // --- secondary constructor used with Room
/***************************************************************************************************
 * The sample data does not contain the requiresPolice column. This secondary constructor allows
 * Room to construct Crime table without worrying about that additional field which was added to
 * complete a challenge.
 *
 * * Fixes Error: Entities and Pojos must have a usable public constructor.
 **************************************************************************************************/
    constructor(id: UUID, title: String, date: Date, isSolved: Boolean)
        : this(id, title, date, isSolved, false)
}