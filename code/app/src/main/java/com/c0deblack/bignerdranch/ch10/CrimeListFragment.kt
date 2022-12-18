package com.c0deblack.bignerdranch.ch10

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

private const val TAG = "CrimeListFragment"
/***************************************************************************************************
 * Crime List Fragment.
 * Contains the list of crimes shown to the user.
 **************************************************************************************************/
class CrimeListFragment : Fragment() {
    // --- create a reference to the viewModel
    private val crimeListViewModel: CrimeViewModel by viewModels()

    // --- log the number of crimes when the fragment is created
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total crimes: ${crimeListViewModel.crimes.size}")
    }
}