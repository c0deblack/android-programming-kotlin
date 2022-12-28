package com.c0deblack.bignerdranch.ch13

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.c0deblack.bignerdranch.androidprogramming.databinding.Ch12LayoutChallenge16ListItemCrimeBinding
import com.c0deblack.bignerdranch.androidprogramming.databinding.Ch12LayoutChallenge16ListItemPoliceBinding
import com.google.android.material.snackbar.Snackbar

// --- constants used to define view types used with the recycler view
// --- the recycler view will display a different view type if the crime requires police
const val defaultViewType = 0
const val requiresPoliceViewType = 1

/***************************************************************************************************
 * Declares a type that is used with the adapter. Each item list view type is encapsulated in a
 * view holder than extends this class. Polymorphism enables the adapter to use any class derived
 * from this base class.
 * @param binding a [ViewBinding] type that represents an XML resource.
 **************************************************************************************************/
abstract class BaseHolder (
    private val binding: ViewBinding
) : RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(crime: Crime)
}
/***************************************************************************************************
 * A view holder that provides the view displayed for each item of a [RecyclerView]. The base
 * [RecyclerView.ViewHolder] is given the root of the binding provided by the constructor.
 * The base class keeps a reference to the item's view in the [RecyclerView.ViewHolder.itemView]
 * variable.
 * @param binding a viewBinding for the item view used in the RecyclerView.
 **************************************************************************************************/
class CrimeHolder(
    val binding: Ch12LayoutChallenge16ListItemCrimeBinding
) : BaseHolder(binding) {
/***************************************************************************************************
 * Bind crime data to the item view used in the [RecyclerView].
 * @param crime a single [Crime] instance.
 **************************************************************************************************/
    override fun bind(crime: Crime) {
        binding.apply {
            // --- bind data
            crimeTitle.text = crime.title
            crimeDate.text  = DateFormat.format("EEEE, MMM d, yyyy", crime.date)

            // --- set onClick event if an item in the list is clicked
            root.setOnClickListener {
                Snackbar.make(
                    binding.root,
                    "${crime.title} clicked!",
                    Snackbar.LENGTH_SHORT
                ).show()
            }

            // --- show the handcuff image if the crime is solved
            crimeSolved.visibility = if (crime.isSolved) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }
}
/***************************************************************************************************
 * Contains the view used for the crimes that require police.
 **************************************************************************************************/
class PoliceViewHolder (
    val binding: Ch12LayoutChallenge16ListItemPoliceBinding
) : BaseHolder(binding) {
/***************************************************************************************************
 * Bind crime data to the item view used in the [RecyclerView].
 * @param crime a single [Crime] instance.
 **************************************************************************************************/
    override fun bind(crime: Crime) {
        binding.apply {
            // --- bind data
            crimeTitle.text = crime.title
            crimeDate.text  = DateFormat.format("EEEE, MMM d, yyyy", crime.date)

            // --- set onClick event if an item in the list is clicked
            contactPolice.setOnClickListener {
                Snackbar.make(
                    binding.root,
                    "Contact Police",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }
}
/***************************************************************************************************
 * The adapter used with the [RecyclerView] displayed in the [CrimeListFragment]'s layout.
 * * Extends [RecyclerView.Adapter]
 **************************************************************************************************/
class CrimeListAdapter (
    private val crimes : List<Crime>
): RecyclerView.Adapter<BaseHolder>() {
/***************************************************************************************************
 * Create an instance of and return the viewHolder used to encapsulate each item in the
 * [RecyclerView].
 * * Overrides [RecyclerView.Adapter.onCreateViewHolder]
 **************************************************************************************************/
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseHolder {
        // --- obtain a layout inflater from the parent view
        val inflater = LayoutInflater.from(parent.context)
        // --- inflate the list item XML resource

        return if (viewType == requiresPoliceViewType) {
            val binding = Ch12LayoutChallenge16ListItemPoliceBinding.inflate(inflater, parent, false)
            PoliceViewHolder(binding)
        } else {
            val binding = Ch12LayoutChallenge16ListItemCrimeBinding.inflate(inflater, parent, false)
            CrimeHolder(binding)
        }
    }
/***************************************************************************************************
 * Binding data from the list item to the view held within the [RecyclerView.ViewHolder].
 * * Overrides [RecyclerView.Adapter.onBindViewHolder]
 **************************************************************************************************/
    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        val crime = crimes[position]
        // --- bind data from the crime to the view within the viewHolder
        holder.bind(crime)
    }
/***************************************************************************************************
 * Returns the total number of elements in the list to the [RecyclerView].
 **************************************************************************************************/
    override fun getItemCount(): Int {
        return crimes.size
    }
/***************************************************************************************************
 * Returns an integer representing the type of view that needs to be displayed.
 **************************************************************************************************/
    override fun getItemViewType(position: Int): Int {
        val crime = crimes[position]
        return when (crime.requiresPolice) {
            false -> defaultViewType    // use the default view
            true -> requiresPoliceViewType   // use the requires police view
        }
    }
}