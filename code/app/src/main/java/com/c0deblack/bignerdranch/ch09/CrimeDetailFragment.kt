package com.c0deblack.bignerdranch.ch09

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.c0deblack.bignerdranch.androidprogramming.databinding.Ch09LayoutFragmentCrimeDetailBinding
import java.util.*

/***************************************************************************************************
 * The Crime Detail Fragment.
 * Displays detailed information about a single [Crime].
 **************************************************************************************************/
class CrimeDetailFragment : Fragment() {
/***************************************************************************************************
 * Private Fragment Properties
 **************************************************************************************************/
    // --- Private instance of a single [Crime] object.
    private lateinit var crime: Crime
    // --- Reference to the fragment's layout [Ch09LayoutFragmentCrimeDetailBinding].
    private lateinit var binding: Ch09LayoutFragmentCrimeDetailBinding
/***************************************************************************************************
 * The onCreate Method.
 * Initialize the fragments private variables. A private instance of a [Crime] object is
 * initialized.
 **************************************************************************************************/
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // --- initialize crime object using named arguments
        crime = Crime(
            id = UUID.randomUUID(),
            title = "",
            date = Date(),
            isSolved = false
        )
    }
/***************************************************************************************************
 * The onCreateView Method.
 * Inflates the root view used by the fragment and returns the root element. This method overrides
 * [Fragment.onCreateView].
 * @link https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#oncreateview
 **************************************************************************************************/
    public override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = Ch09LayoutFragmentCrimeDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
/***************************************************************************************************
 * The onViewCreated Method.
 * Add logic to views created from the [CrimeDetailFragment.onCreateView] method. This method
 * overrides [Fragment.onViewCreated].
 **************************************************************************************************/
    public override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // --- use the apply scoped function to access members of the binding object
        binding.apply {
            // --- update the crime title whenever the EditView contents change
            crimeTitle.doOnTextChanged { text, _, _, _ ->
                crime = crime.copy(title = text.toString())
            }
            // --- show the current date in the CrimeDate button
            crimeDate.apply {
                text = crime.date.toString()
                isEnabled = false
            }
            // --- update the crime object when the user checks/unchecks the crimeSolved checkbox
            crimeSolved.setOnCheckedChangeListener { _, isChecked ->
                crime = crime.copy(isSolved = isChecked)
            }
        }
    }
}