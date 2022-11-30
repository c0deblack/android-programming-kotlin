package com.c0deblack.bignerdranch.ch01_challenge1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.c0deblack.bignerdranch.androidprogramming.R
import com.google.android.material.snackbar.Snackbar

/***************************************************************************************************
 * Main Activity for the GeoQuiz App.
 **************************************************************************************************/
class MainActivity : AppCompatActivity() {
/***************************************************************************************************
 * Define variables that will hold references to the Button views.
 *
 * The lateinit modifier allows initialization of non-null property outside of constructor
 * @see: https://kotlinlang.org/docs/properties.html#late-initialized-properties-and-variables
 **************************************************************************************************/
    private lateinit var trueButton : Button
    private lateinit var falseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
/***************************************************************************************************
 * Inflate the XML chapter01_activity_main.xml resource
 ***************************************************************************************************/
        setContentView(R.layout.ch01_layout_challenge1)
/***************************************************************************************************
 * Get a reference to the two Button views
 **************************************************************************************************/
        trueButton  = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
/***************************************************************************************************
 * Get a reference to the two Button views
 **************************************************************************************************/

/***************************************************************************************************
 * Challenge #1: Switching Your Toast for a Snackbar
 *
 * Set onClick Listeners for the two buttons. When a button is clicked a corresponding Snackbare
 * message is displayed to the user.
 **************************************************************************************************/
        trueButton.setOnClickListener { view: View ->
            Snackbar.make(
                findViewById(R.id.root),
                R.string.correct_toast,
                Snackbar.LENGTH_SHORT
            ).show()
        }
        falseButton.setOnClickListener { view: View ->
            Snackbar.make(
                findViewById(android.R.id.content),
                R.string.incorrect_toast,
                Snackbar.LENGTH_SHORT
            ).show()
        }
    } // END onCreate(savedInstanceState: Bundle?)
}