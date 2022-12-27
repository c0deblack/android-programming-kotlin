package com.c0deblack.bignerdranch.ch12

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import java.util.UUID

/***************************************************************************************************
 * Interface used to access the database in an object oriented fashion.
 **************************************************************************************************/
@Dao
interface CrimeDao {
    // --- get all the crimes
    // --- return a Kotlin Flow object
    @Query("SELECT * FROM Crime")
    fun getCrimes(): Flow<List<Crime>>

    // --- get a single crime based on its UUID
    @Query("SELECT * FROM Crime WHERE id=(:id)")
    suspend fun getCrime(id: UUID) : Crime
}