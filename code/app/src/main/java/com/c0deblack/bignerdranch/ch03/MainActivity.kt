package com.c0deblack.bignerdranch.ch03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.c0deblack.bignerdranch.androidprogramming.R
import com.c0deblack.bignerdranch.androidprogramming.databinding.Ch03LayoutBinding
import com.google.android.material.snackbar.Snackbar

/***************************************************************************************************
 * Logging Tag
 * Tag used for log messages from the MainActivity
 **************************************************************************************************/
private const val TAG = "MainActivity"
/***************************************************************************************************
 * Main Activity for the GeoQuiz App.
 **************************************************************************************************/
class MainActivity : AppCompatActivity() {
    // --- reference to the View Binding object. Gives access to all layout elements with an ID
    // --- attribute.
    private lateinit var binding: Ch03LayoutBinding

    // --- each question is an instance of the Question data class. Each question keeps track of the
    // --- string resource ID and the answer ot he question.
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    // --- keeps track of the index of the current question in the list.
    private var currentIndex = 0

/***************************************************************************************************
 * Override [AppCompatActivity.onCreate] and perform initialization operations.
 **************************************************************************************************/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // --- logging onCreate
        Log.d(TAG, "onCreate(Bundle?) called")

        // --- inflate the chapter02_activity_main.xml resource using the View Binding
        binding = Ch03LayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // --- set the on click listeners for the two buttons. When a button is clicked a corresponding
        // --- snackbar message is displayed to the user.
        binding.trueButton.setOnClickListener {
            checkAnswer(true)
        }
        binding.falseButton.setOnClickListener {
            checkAnswer(false)
        }

        // --- when the next button is clicked, currentIndex increments by 1.
        // --- it resets back to 0 if it has reached the end of the Questions list.
        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestions()
        }

        // --- Challenge #2: Add a Listener to the TextView
        // --- add "Next" feature to the TextView as on onClick Event
        binding.questionTextView.setOnClickListener{
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestions()
        }

        // --- Challenge #3: Adding a Previous Button
        // --- add a previous button
        binding.previousButton.setOnClickListener {
            currentIndex = if (currentIndex == 0){
                questionBank.size - 1
            } else {
                currentIndex - 1
            }
            updateQuestions()
        }
        // --- set the text in the text view when the view is created.
        this.updateQuestions()
    } // END onCreate
    override fun onStart(){
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume(){
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause(){
        super.onPause()
        Log.d(TAG, "onPause() called")
    }
    override fun onStop(){
        super.onStop()
        Log.d(TAG, "onStop() called")
    }
    override fun onDestroy(){
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }
/***************************************************************************************************
 * private fun updateQuestions()
 *
 * Grabs the currentIndex from the Questions list and sets the text view with its question.
 **************************************************************************************************/
    private fun updateQuestions() {
        val questionTextResId = questionBank[currentIndex].textResID
        binding.questionTextView.setText(questionTextResId)
    }
/***************************************************************************************************
 * private fun checkAnswer(Boolean)
 *
 * Receives true or false and checks if the Question at the currentIndex has a matching answer.
 **************************************************************************************************/
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val messageId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        Snackbar.make(
            binding.root,
            messageId,
            Snackbar.LENGTH_SHORT
        ).show()
    }
} // END MainActivity