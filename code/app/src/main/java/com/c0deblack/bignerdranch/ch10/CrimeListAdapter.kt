package com.c0deblack.bignerdranch.ch10

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.c0deblack.bignerdranch.androidprogramming.databinding.Ch10LayoutListItemCrimeBinding

/***************************************************************************************************
 * A view holder that provides the view displayed for each item of a [RecyclerView]. The base
 * [RecyclerView.ViewHolder] is given the root of the binding provided by the constructor.
 * The base class keeps a reference to the item's view in the [RecyclerView.ViewHolder.itemView]
 * variable.
 * @param binding a viewBinding for the item view used in the RecyclerView.
 * @constructor calls the base constructor passing in the binding's root element.
 * * Extends [RecyclerView.ViewHolder]
 **************************************************************************************************/
class CrimeHolder (
    val binding: Ch10LayoutListItemCrimeBinding
) : RecyclerView.ViewHolder(binding.root) {
}

class CrimeListAdapter (
    private val crimes : List<Crime>
): RecyclerView.Adapter<CrimeHolder>() {
/***************************************************************************************************
 * Create an instance of and return the viewHolder used to encapsulate each item in the
 * [RecyclerView].
 * * Overrides [RecyclerView.Adapter.onCreateViewHolder]
 **************************************************************************************************/
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CrimeHolder {
        // --- obtain a layout inflater from the parent view
        val inflater = LayoutInflater.from(parent.context)
        // --- inflate the list item XML resource
        val binding = Ch10LayoutListItemCrimeBinding.inflate(inflater, parent, false)
        // --- instantiate and return a CrimeHolder containing the provided item view binding
        return CrimeHolder(binding)
    }
/***************************************************************************************************
 * Binding data from the list item to the view held within the [RecyclerView.ViewHolder].
 * * Overrides [RecyclerView.Adapter.onBindViewHolder]
 **************************************************************************************************/
    override fun onBindViewHolder(holder: CrimeHolder, position: Int) {
        val crime = crimes[position]
        // --- bind data from the crime to the view within the viewHolder
        holder.apply {
            binding.apply {
                crimeTitle.text = crime.title
                crimeDate.text = crime.date.toString()
            }
        }
    }
/***************************************************************************************************
 * Returns the total number of elements in the list to the [RecyclerView].
 **************************************************************************************************/
    override fun getItemCount(): Int {
        return crimes.size
    }

}