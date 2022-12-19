package com.c0deblack.bignerdranch.ch03_challenge5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.StringRes
import com.c0deblack.bignerdranch.androidprogramming.R
import com.c0deblack.bignerdranch.androidprogramming.databinding.Ch03LayoutChallenge5Binding
import com.google.android.material.snackbar.Snackbar

/***************************************************************************************************
 * Logging Tag
 *
 * Tag used for log messages from the MainActivity
 **************************************************************************************************/
private const val TAG = "MainActivity"
/***************************************************************************************************
 * Main Activity for the GeoQuiz App.
 **************************************************************************************************/
class MainActivity : AppCompatActivity() {
    // --- reference to the View Binding object. Gives access to all layout elements with an ID
    // --- attribute.
    private lateinit var binding: Ch03LayoutChallenge5Binding

    // --- This variable is used to keep track of the state of the answer  (true/false) buttons.
    private var buttonState = true

    // --- keeps track of the number of correctly answered questions. Used to get the final score %.
    private var numCorrect = 0f

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
        binding = Ch03LayoutChallenge5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // --- set the on click listeners for the two buttons. When a button is clicked a corresponding
        // --- snackbar message is displayed to the user.
        binding.trueButton.setOnClickListener {
            setQuestionAnswered(questionBank[currentIndex])
            setAnswerButtonState()
            checkAnswer(true)
        }
        binding.falseButton.setOnClickListener {
            setQuestionAnswered(questionBank[currentIndex])
            setAnswerButtonState()
            checkAnswer(false)
        }

        // --- when the next button is clicked, currentIndex increments by 1.
        // --- it resets back to 0 if it has reached the end of the Questions list.
        binding.nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestions()
            setAnswerButtonState()
        }

        // --- Challenge #2: Add a Listener to the TextView
        // --- add "Next" feature to the TextView as on onClick Event
        binding.questionTextView.setOnClickListener{
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestions()
            setAnswerButtonState()
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
            setAnswerButtonState()
        }

        // --- set the text in the text view when the view is created.
        this.updateQuestions()
    }
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
 * Update Question Text
 * Grabs the currentIndex from the Questions list and sets the text view with its question.
 **************************************************************************************************/
    private fun updateQuestions() {
        val questionTextResId = questionBank[currentIndex].textResID
        binding.questionTextView.setText(questionTextResId)
    }

/***************************************************************************************************
 * Check If All Answered
 * Checks the questionBank to see all questions are answered.
 **************************************************************************************************/
    private fun isAllAnswered(): Boolean {
        for(question in questionBank){
            if(!question.isAnswered) return false
        }
        return true
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
        val correctAnswer = questionBank[currentIndex].answer
        val messageId = if (userAnswer == correctAnswer) {
            numCorrect++
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }
        displaySnackbar(messageId)

        if(isAllAnswered()){
            displaySnackbar(
                getString(R.string.score, (numCorrect / questionBank.size) * 100))
        }
}
/***************************************************************************************************
 * Set Question Answer State
 * Challenge #4: Prevent Repeat Answers
 ***************************************************************************************************/
    private fun setQuestionAnswered(question: Question){
        question.isAnswered = true
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
        if(questionBank[currentIndex].isAnswered){
            disableButtons()
        } else {
            enableButtons()
        }
    }
}
