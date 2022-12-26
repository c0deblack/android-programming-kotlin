package com.c0deblack.bignerdranch.ch12_challenge16

import androidx.room.Dao
import androidx.room.Query
import java.util.UUID

/***************************************************************************************************
 * Interface used to access the database in an object oriented fashion.
 **************************************************************************************************/
@Dao
interface CrimeDao {
    // --- get all the crimes
    @Query("SELECT * FROM Crime")
    suspend fun getCrimes(): List<Crime>

    // --- get a single crime based on its UUID
    @Query("SELECT * FROM Crime WHERE id=(:id)")
    suspend fun getCrime(id: UUID) : Crime
}