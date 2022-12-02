package com.c0deblack.bignerdranch.ch06

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import com.c0deblack.bignerdranch.androidprogramming.R

@RunWith(AndroidJUnit4::class)
class QuizVieOwModelTest {
/***************************************************************************************************
 * Get Instance of MainActivity
 *
 * Use the ActivityScenario APIs to gain access to and control an Activity's lifecycle.
 **************************************************************************************************/
    private lateinit var scenario: ActivityScenario<MainActivity>
/***************************************************************************************************
 * Setup and Teardown
 *
 * Setup the test environment.
 **************************************************************************************************/
    @Before
    fun setUp() {
        scenario = launch(MainActivity::class.java)
    }
    @After
    fun tearDown() {
        scenario.close()
    }
/***************************************************************************************************
 * Test First Question Shown
 *
 * Make sure the first question is showing properly in the TextView. This uses a fluid interface
 * provided by Espresso that chains functions to match views with an assertion.
 **************************************************************************************************/
    @Test
    fun showFirstQuestionLaunch(){
        onView(withId(R.id.question_text_view))
            .check(matches(withText(R.string.question_australia)))
    }
/***************************************************************************************************
 * Very Button Click Changes TextView Text
 *
 * Perform a click on a view and verify the resulting UI. A click event is performed on a view
 * matched by its ID. The view's contents are then asserted to equal a given string resource.
 **************************************************************************************************/
    @Test
    fun showSecondQuestionAfterNextPress(){
        onView(withId(R.id.next_button)).perform(click())
        onView(withId(R.id.question_text_view))
            .check(matches(withText(R.string.question_oceans)))
    }
/***************************************************************************************************
 * Test State Does Not Change After Recreation
 *
 * This test calls the ActivityScenario.recreate() method to simulate a configuration state change.
 **************************************************************************************************/
    @Test
    fun handlesActivityRecreation() {
        onView(withId(R.id.next_button)).perform(click())
        scenario.recreate()
        onView(withId(R.id.question_text_view))
            .check(matches(withText(R.string.question_oceans)))
    }
}
