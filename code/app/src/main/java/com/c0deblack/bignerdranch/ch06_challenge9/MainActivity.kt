package com.c0deblack.bignerdranch.ch06_challenge9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.StringRes
import androidx.activity.viewModels
import com.c0deblack.bignerdranch.androidprogramming.R
import com.c0deblack.bignerdranch.androidprogramming.databinding.Ch06LayoutChallenge9Binding
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
/***************************************************************************************************
 * View Binding
 * Reference to the View Binding object. Gives access to all layout elements with an ID attribute.
 **************************************************************************************************/
    private lateinit var binding: Ch06LayoutChallenge9Binding
/***************************************************************************************************
* ViewModel
 * Create a reference to the QuizViewModel and invoke the viewModels() property delegate.
 **************************************************************************************************/
    private val quizViewModel: QuizViewModel by viewModels()
/***************************************************************************************************
* Answer Button State
* This variable is used to keep track of the state of the answer  (true/false) buttons.
**************************************************************************************************/
    private var buttonState = true
/***************************************************************************************************
 * Number Correct
 * Keeps track of the number of correctly answered questions. Used to get the final score %.
 **************************************************************************************************/
    private var numCorrect = 0f
/*################################################################################################*/
// START onCreate(savedInstanceState: Bundle?)
/*################################################################################################*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
/***************************************************************************************************
* Logging onCreate
***************************************************************************************************/
        Log.d(TAG, "onCreate(Bundle?) called")
/***************************************************************************************************
 * Inflate the XML
 * Inflate the chapter02_activity_main.xml resource using the View Binding
 ***************************************************************************************************/
        binding = Ch06LayoutChallenge9Binding.inflate(layoutInflater)
        setContentView(binding.root)
/***************************************************************************************************
 * Log ViewModel
 * Initializing the quizViewModel and logging its value in one line. The value is lazy initialized.
 ***************************************************************************************************/
        Log.d(TAG, "Got a QuizViewModel: $quizViewModel")
/***************************************************************************************************
 * Answer Buttons Events
 * Set the on click listeners for the two buttons. When a button is clicked a corresponding
 * `Snackbar` message is displayed to the user.
 *
 * Challenge #4: Prevent Repeat Answers
 *      Added the disableButtons function call
 **************************************************************************************************/
        binding.trueButton.setOnClickListener {
            quizViewModel.setQuestionAnswered()
            setAnswerButtonState()
            checkAnswer(true)
        }
        binding.falseButton.setOnClickListener {
            quizViewModel.setQuestionAnswered()
            setAnswerButtonState()
            checkAnswer(false)
        }
/***************************************************************************************************
 * Next Button Event
 * When the next button is clicked, currentIndex increments by 1. It resets back to 0 if it has
 * reached the end of the Questions list.
 *
 * Challenge #4: Prevent Repeat Answers
 *      Added enableButtons function call
 **************************************************************************************************/
        binding.nextButton.setOnClickListener {
            quizViewModel.moveToNext()
            updateQuestions()
            setAnswerButtonState()
        }
/***************************************************************************************************
 * TextView As Next Button
 * Challenge #2: Add a Listener to the TextView
 *      Add "Next" feature to the TextView as on onClick Event
 **************************************************************************************************/
        binding.questionTextView.setOnClickListener{
            quizViewModel.moveToNext()
            updateQuestions()
            setAnswerButtonState()
        }
/***************************************************************************************************
 * Previous Button
 * Challenge #3: Adding a Previous Button
 **************************************************************************************************/
        binding.previousButton.setOnClickListener {
            quizViewModel.moveToPrevious()
            updateQuestions()
            setAnswerButtonState()
        }
/***************************************************************************************************
 * Set Text
 * Set the text in the text view when the view is created.
 **************************************************************************************************/
        this.updateQuestions()
        this.setAnswerButtonState()
}
/*################################################################################################*/
// END onCreate(savedInstanceState: Bundle?)
/*################################################################################################*/
/*################################################################################################*/
// START Logging Lifecycle Methods
/*################################################################################################*/
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
/*################################################################################################*/
// END Logging Lifecycle Methods
/*################################################################################################*/
/***************************************************************************************************
 * Update Question Text
 * Grabs the currentIndex from the Questions list and sets the text view with its question.
 **************************************************************************************************/
    private fun updateQuestions() {
        val questionTextResId = quizViewModel.currentQuestionText
        binding.questionTextView.setText(questionTextResId)
    }
/***************************************************************************************************
 * Display Snackbar
 * Displays a Snackbar showing it with specified text from a passed in string resource ID.
 **************************************************************************************************/
    private fun displaySnackbar(@StringRes messageId: Int, length: Int = Snackbar.LENGTH_SHORT ){
        Snackbar.make(
            binding.root,
            messageId,
            length
        ).show()
    }
/***************************************************************************************************
 * Display Snackbar
 * Displays a Snackbar showing it with a specified string.
 **************************************************************************************************/
    private fun displaySnackbar(message: String, length: Int = Snackbar.LENGTH_SHORT ){
        Snackbar.make(
            binding.root,
            message,
            length
        ).show()
    }
/***************************************************************************************************
 * Check Answer
 * Challenge #1: Switching Your Toast for a Snackbar
 *      Receives true or false and checks if the Question at the currentIndex has a matching answer.
 * Challenge #5: Graded Quiz
 *      Increments the numCorrect variable.
 *      Displays the score after the user provides answers to all questions.
 **************************************************************************************************/
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = quizViewModel.currentQuestionAnswer
        val messageId = if (userAnswer == correctAnswer) {
            numCorrect++
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        displaySnackbar(messageId)

        if(quizViewModel.isAllAnswered()){
            displaySnackbar(
                getString
                    (R.string.score, (numCorrect / quizViewModel.questionBankSize) * 100))
        }
}
/***************************************************************************************************
* Set View Enabled State
* Challenge #4: Prevent Repeat Answers
*       Utility function used to set the Enabled state of one or more views.
***************************************************************************************************/
    private fun setViewIsEnabled(state: Boolean, vararg views: View) {
        for(view in views){
            view.isEnabled = state
        }
    }
/***************************************************************************************************
 * Disable Answer Buttons
 * Challenge #4: Prevent Repeat Answers
 ***************************************************************************************************/
    private fun disableButtons(){
        if (buttonState) {
            setViewIsEnabled(false, binding.falseButton, binding.trueButton)
            buttonState = false
        }
    }
/***************************************************************************************************
 * Enable Answer Buttons
 * Challenge #4: Prevent Repeat Answers
 ***************************************************************************************************/
    private fun enableButtons(){
        if (!buttonState){
            setViewIsEnabled(true, binding.falseButton, binding.trueButton)
            buttonState = true
        }
    }
/***************************************************************************************************
 * Update Answer Button Status
 * Challenge #4: Prevent Repeat Answers
 *      Checks if the question at the current index was answered and either disables or enables the
 *      answer buttons.
 ***************************************************************************************************/
    private fun setAnswerButtonState() {
        if(quizViewModel.checkIfAnswered()){
            disableButtons()
        } else {
            enableButtons()
        }
    }
/*################################################################################################*/
// END class MainActivity
/*################################################################################################*/
}
