package com.c0deblack.bignerdranch.ch12

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.c0deblack.bignerdranch.androidprogramming.databinding.Ch12LayoutFragmentCrimeListBinding

private const val TAG = "CrimeListFragment"
/***************************************************************************************************
 * Crime List Fragment.
 * Contains the list of crimes shown to the user.
 **************************************************************************************************/
class CrimeListFragment : Fragment() {
    // --- create a nullable backing variable used for the fragment's viewBinding
    // --- also provide a non-null reference to the binding
    private var _binding: Ch12LayoutFragmentCrimeListBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the vie visible?"
        }

    // --- create a reference to the viewModel
    private val crimeListViewModel: CrimeViewModel by viewModels()

/***************************************************************************************************
* Initialize the [CrimeListFragment].
 * * Overrides [Fragment.onCreate].
 **************************************************************************************************/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // --- log the number of crimes when the fragment is created
        Log.d(TAG, "Total crimes: ${crimeListViewModel.crimes.size}")
    }
/***************************************************************************************************
 * Inflate the view used with the [CrimeListFragment].
 * * Overrides [Fragment.onCreateView]
 **************************************************************************************************/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // --- inflate the fragment's layout
        _binding = Ch12LayoutFragmentCrimeListBinding.inflate(
            inflater,
            container,
            false
        )

        // --- assign a layout manager to the RecyclerView
        binding.crimeRecyclerView.layoutManager = LinearLayoutManager(context)

        // --- assign the adapter to the recycler view
        val crimes = crimeListViewModel.crimes
        val adapter = CrimeListAdapter(crimes)
        binding.crimeRecyclerView.adapter = adapter

        // --- return the root view that is displayed
        return binding.root
    }
/***************************************************************************************************
 * Null the reference to the viewBinding when the fragment is destroyed to free unused memory.
 * * Overrides [Fragment.onDestroy]
 **************************************************************************************************/
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}