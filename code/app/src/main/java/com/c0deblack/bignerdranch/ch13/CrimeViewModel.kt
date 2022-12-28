package com.c0deblack.bignerdranch.ch13

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/***************************************************************************************************
 * Crime View Model.
 * This ViewModel stores a list of crimes which are access from the CrimeListFragment.
 **************************************************************************************************/
class CrimeViewModel : ViewModel() {
    private val crimeListRepository = CrimeRepository.get()

    // --- create a private backing mutableStateFlow property
    private var _crimes : MutableStateFlow<List<Crime>> = MutableStateFlow(emptyList())
    // --- create a public stateFlow property
    val crimes : StateFlow<List<Crime>>
        get() = _crimes.asStateFlow()

    init {
        viewModelScope.launch {
            crimeListRepository.getCrimes().collect {
                // --- catch database data in a mutableStateFlow
               _crimes.value = it
            }
        }
    }
}