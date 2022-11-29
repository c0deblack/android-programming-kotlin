package com.c0deblack.bignerdranch.ch01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.c0deblack.bignerdranch.androidprogramming.R

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
        setContentView(R.layout.ch01_layout)
/***************************************************************************************************
 * Get a reference to the two Button views
 **************************************************************************************************/
        trueButton  = findViewById(R.id.true_button);
        falseButton = findViewById(R.id.false_button);
/***************************************************************************************************
 * Set onClick Listeners for the two buttons
 *
 * When a button is clicked a corresponding `Toast` message is displayed to the user.
 **************************************************************************************************/
        trueButton.setOnClickListener{view: View ->
            Toast.makeText(
                this,
                R.string.correct_toast,
                Toast.LENGTH_SHORT
            ).show()
        }
        falseButton.setOnClickListener{view: View ->
            Toast.makeText(
                this,
                R.string.incorrect_toast,
                Toast.LENGTH_SHORT
            ).show()
        }

    } // END onCreate(savedInstanceState: Bundle?)
}