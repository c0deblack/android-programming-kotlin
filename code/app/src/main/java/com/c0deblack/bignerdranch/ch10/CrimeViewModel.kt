package com.c0deblack.bignerdranch.ch10

import androidx.lifecycle.ViewModel
import java.util.*

/***************************************************************************************************
 * Crime View Model.
 * This ViewModel stores a list of crimes which are access from the CrimeListFragment.
 **************************************************************************************************/
class CrimeViewModel : ViewModel() {
    val crimes = mutableListOf<Crime>()
    init {
        // --- generate a random list of 100 crimes
        for (i in 0 until 100) {
            val crime = Crime (
                id = UUID.randomUUID(),
                title = "Crime $i",
                date = Date(),
                isSolved = i % 2 == 0
            )
            crimes += crime
        }
    }
}