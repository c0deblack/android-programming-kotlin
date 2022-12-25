package com.c0deblack.bignerdranch.ch12

import android.content.Context
import androidx.room.Room
import java.util.UUID

private const val DATABASE_NAME = "crime-database"
/***************************************************************************************************
 * Single source of truth for the application. Provides access to the database.
 **************************************************************************************************/
class CrimeRepository private constructor(context: Context) {

    // --- construct the database using the Room API database builder
    // --- context is the application context derived from CriminalIntentApplication
    // --- CrimeDatabase is the abstract database class that will be implemented
    private val database: CrimeDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            CrimeDatabase::class.java,
            DATABASE_NAME
        )
        .createFromAsset(DATABASE_NAME)
        .build()

    // --- pass through calls to the underlying database
    suspend fun getCrimes(): List<Crime> = database.crimeDao().getCrimes()
    suspend fun getCrime(id : UUID) : Crime = database.crimeDao().getCrime(id)

    // --- globally accessible properties
    companion object {

        // --- static instance of this singleton class
        private var INSTANCE: CrimeRepository? = null

/***************************************************************************************************
 * Create new instance or grab the current one if it exists.
 **************************************************************************************************/
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = CrimeRepository(context)
            }
        }
/***************************************************************************************************
 * Get the current instance of the app repository.
 **************************************************************************************************/
        fun get(): CrimeRepository {
            return INSTANCE?: throw IllegalStateException("CrimeRepository must be initialized")
        }
    }
}