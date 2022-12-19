package com.c0deblack.bignerdranch.ch01_challenge1

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

    // --- reference to true/false UI buttons
    private lateinit var trueButton : Button
    private lateinit var falseButton: Button

/***************************************************************************************************
* Override [AppCompatActivity.onCreate] and perform initialization operations.
**************************************************************************************************/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    // --- inflate the XML chapter01_activity_main.xml resource
    setContentView(R.layout.ch01_layout_challenge1)

    // --- assign views to the button variables
    trueButton  = findViewById(R.id.true_button)
    falseButton = findViewById(R.id.false_button)

    // --- set onClick Listeners for the two buttons
    // --- when a button is clicked a corresponding `Toast` message is displayed to the user.
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
