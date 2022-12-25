package com.c0deblack.bignerdranch.ch12

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/***************************************************************************************************
 * Crime View Model.
 * This ViewModel stores a list of crimes which are access from the CrimeListFragment.
 **************************************************************************************************/
class CrimeViewModel : ViewModel() {
    private val crimeListRepository = CrimeRepository.get()
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
        return crimeListRepository.getCrimes()
    }
}