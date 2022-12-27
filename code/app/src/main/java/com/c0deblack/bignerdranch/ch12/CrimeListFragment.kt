package com.c0deblack.bignerdranch.ch12

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.c0deblack.bignerdranch.androidprogramming.databinding.Ch12LayoutFragmentCrimeListBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

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
 * Inflate the view used with the [CrimeListFragment].
 * * Overrides [Fragment.onCreateView]
 **************************************************************************************************/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // --- inflate the fragment's layout
        _binding = Ch12LayoutFragmentCrimeListBinding.inflate(
            inflater,
            container,
            false
        )

        // --- assign a layout manager to the RecyclerView
        binding.crimeRecyclerView.layoutManager = LinearLayoutManager(context)

        // --- return the root view that is displayed
        return binding.root
    }
/***************************************************************************************************
 * Hook up listeners / set data within views.
 * * Overrides [Fragment.onViewCreated]
 **************************************************************************************************/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // --- use a coroutine to load data from the view model and update the recycler view
        viewLifecycleOwner.lifecycleScope.launch{
            // --- launch a coroutine without the need for manual cleanup
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                // --- observe data emitted from a Kotlin Flow object
                crimeListViewModel.crimes.collect() {
                    // --- update the recyclerview adapter with collected data
                    binding.crimeRecyclerView.adapter = CrimeListAdapter(it)
               }
           }
        }
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