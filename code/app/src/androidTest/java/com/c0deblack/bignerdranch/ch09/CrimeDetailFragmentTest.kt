package com.c0deblack.bignerdranch.ch09

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

/***************************************************************************************************
 * Testing fragments.
 **************************************************************************************************/
@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {
/***************************************************************************************************
 *  Test that the checkbox onChecked listener is working within the CrimeDetailFragment. Success
 *  results from the listener setting crime.isSolved to true.
 **************************************************************************************************/
    @Test
    fun testCheckBox() {
        val fragment = launchFragmentInContainer<CrimeDetailFragment>()
        fragment.onFragment{ frag ->
            frag.binding.crimeSolved.isChecked = true
            assert(frag.crime.isSolved /* == true */)
        }
    }
}