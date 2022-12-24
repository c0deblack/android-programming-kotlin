package com.c0deblack.bignerdranch.ch12

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*

/***************************************************************************************************
 * Crime View Model.
 * This ViewModel stores a list of crimes which are access from the CrimeListFragment.
 **************************************************************************************************/
class CrimeViewModel : ViewModel() {
    val crimes = mutableListOf<Crime>()
    init {
        Log.d("viewModel", "init started")
        viewModelScope.launch {
            Log.d("viewModel", "Coroutine launched")

            crimes += loadCrimes()
            Log.d("viewModel", "Coroutine finished")
        }
    }

/***************************************************************************************************
 * Load Crimes in Coroutine.
 **************************************************************************************************/
    suspend fun loadCrimes(): List<Crime> {
        val result = mutableListOf<Crime>()
        // --- generate a random list of 100 crimes
        delay(5000)
        for (i in 0 until 100) {
            val crime = Crime (
                id = UUID.randomUUID(),
                title = "Crime $i",
                date = Date(),
                isSolved = i % 2 == 0,
                requiresPolice = i % 5 == 0
            )
            result += crime
        }
        return result
    }
}