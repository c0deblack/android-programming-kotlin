package com.c0deblack.bignerdranch.ch12

import androidx.lifecycle.ViewModel

/***************************************************************************************************
 * Crime View Model.
 * This ViewModel stores a list of crimes which are access from the CrimeListFragment.
 **************************************************************************************************/
class CrimeViewModel : ViewModel() {
    private val crimeListRepository = CrimeRepository.get()
    val crimes = mutableListOf<Crime>()

/***************************************************************************************************
 * Load Crimes from the database in a Coroutine.
 **************************************************************************************************/
    suspend fun loadCrimes(): List<Crime> {
        return crimeListRepository.getCrimes()
    }
}