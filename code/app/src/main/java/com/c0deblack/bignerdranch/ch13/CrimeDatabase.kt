package com.c0deblack.bignerdranch.ch13

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

/***************************************************************************************************
 * Database class used with the Room API.
 * * Overrides [RoomDatabase].
 **************************************************************************************************/
@Database(entities = [ Crime::class ], version = 1, exportSchema = true)
@TypeConverters(CrimeTypeConverter::class)
abstract class CrimeDatabase : RoomDatabase() {
    abstract fun crimeDao(): CrimeDao
}