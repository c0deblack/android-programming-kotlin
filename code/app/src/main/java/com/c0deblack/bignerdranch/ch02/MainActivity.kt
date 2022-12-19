package com.c0deblack.bignerdranch.ch02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.c0deblack.bignerdranch.androidprogramming.R
import com.c0deblack.bignerdranch.androidprogramming.databinding.Ch02LayoutBinding
import com.google.android.material.snackbar.Snackbar

/***************************************************************************************************
 * Main Activity for the GeoQuiz App.
 **************************************************************************************************/
class MainActivity : AppCompatActivity() {
    // --- reference to the View Binding object. Gives access to all layout elements with an ID
    // --- attribute.
    private lateinit var binding: Ch02LayoutBinding

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

        // --- inflate the chapter02_activity_main.xml resource using the View Binding
        binding = Ch02LayoutBinding.inflate(layoutInflater)
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

        this.updateQuestions()
    } // END onCreate
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