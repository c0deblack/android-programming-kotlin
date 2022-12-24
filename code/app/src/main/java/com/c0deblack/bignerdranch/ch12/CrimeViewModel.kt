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
        viewModelScope.launch {
            // --- generate a random list of 100 crimes
            Log.d("viewModel", "Coroutine launched")
            delay(5000)
            for (i in 0 until 100) {
                val crime = Crime (
                    id = UUID.randomUUID(),
                    title = "Crime $i",
                    date = Date(),
                    isSolved = i % 2 == 0,
                    requiresPolice = i % 5 == 0
                )
                crimes += crime
                Log.d("viewModel", "Coroutine finished")
            }
        }
    }
}