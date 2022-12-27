package com.c0deblack.bignerdranch.ch12_challenge16

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.c0deblack.bignerdranch.androidprogramming.databinding.Ch12LayoutChallenge16FragmentCrimeDetailBinding
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
    lateinit var crime: Crime
    // --- Nullable backing property for the viewBinding
    private var _binding: Ch12LayoutChallenge16FragmentCrimeDetailBinding? = null
    // --- Reference to the fragment's layout [Ch09LayoutFragmentCrimeDetailBinding].
    val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null. Is the view visible?"
        }

    // --- create a reference to the viewModel
    private val crimeListViewModel: CrimeViewModel by viewModels()
/***************************************************************************************************
 * The onCreate Method.
 * Initialize the fragments private variables. A private instance of a [Crime] object is
 * initialized.
 **************************************************************************************************/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // --- initialize crime object using named arguments
        crime = Crime(
            id = UUID.randomUUID(),
            title = "",
            date = Date(),
            isSolved = false,
            requiresPolice = false
        )
    }
/***************************************************************************************************
 * The onCreateView Method.
 * Inflates the root view used by the fragment and returns the root element. This method overrides
 * [Fragment.onCreateView].
 * @link https://developer.android.com/reference/kotlin/androidx/fragment/app/Fragment#oncreateview
 **************************************************************************************************/
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = Ch12LayoutChallenge16FragmentCrimeDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
/***************************************************************************************************
 * The onViewCreated Method.
 * Add logic to views created from the [CrimeDetailFragment.onCreateView] method. This method
 * overrides [Fragment.onViewCreated].
 **************************************************************************************************/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
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
/***************************************************************************************************
 * The onDestroyView Method.
 * Used to null out the reference to the viewBinding. Fragment views are destroyed when not shown.
 * Nulling out the reference allows unused memory to be freed.
 **************************************************************************************************/
    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}