package com.c0deblack.bignerdranch.ch09

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {
/***************************************************************************************************
 * TODO: Verify this test.
 * There appears to be a bug with the fragment-testing dependency in build gradle. That library is
 * a requirement for the FragmentScenario class.
 *
 * issue: https://issuetracker.google.com/issues/260214138
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