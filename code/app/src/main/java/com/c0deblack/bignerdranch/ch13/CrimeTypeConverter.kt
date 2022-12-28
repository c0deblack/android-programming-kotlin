package com.c0deblack.bignerdranch.ch13

import androidx.room.TypeConverter
import java.util.*

/***************************************************************************************************
* Convert to/from complex data types and a datatype Room database can understand.
**************************************************************************************************/
class CrimeTypeConverter {
    // --- convert to and from the Date type
    @TypeConverter
    fun fromDate(date: Date) : Long {
        return date.time
    }
    @TypeConverter
    fun toDate(millisSinceEpoch: Long) : Date {
        return Date(millisSinceEpoch)
    }
}