package com.c0deblack.bignerdranch.ch07_challenge11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.StringRes
import androidx.activity.viewModels
import com.c0deblack.bignerdranch.androidprogramming.R
import com.c0deblack.bignerdranch.androidprogramming.databinding.Ch07LayoutChallenge11Binding
import com.google.android.material.snackbar.Snackbar

/***************************************************************************************************
 * Tag used for log messages from the MainActivity
 **************************************************************************************************/
private const val TAG = "MainActivity"
/***************************************************************************************************
 * Main Activity for the GeoQuiz App.
 **************************************************************************************************/
class MainActivity : AppCompatActivity() {
    // --- reference to the View Binding object. Gives access to all layout elements with an ID
    // --- attribute.
    private lateinit var binding: Ch07LayoutChallenge11Binding

    // --- create a reference to the QuizViewModel and invoke the viewModels() property delegate.
    private val quizViewModel: QuizViewModel by viewModels()

    // --- This variable is used to keep track of the state of the answer  (true/false) buttons.
    private var buttonState = true

    // --- keeps track of the number of correctly answered questions. Used to get the final score %.
    private var numCorrect = 0f

/***************************************************************************************************
 * Create Activity Launcher
 * Used to handle the result of a launched activity. Uses [registerForActivityResult] to obtain an
 * [androidx.activity.result.ActivityResultLauncher] that is used to launch the CheatActivity. A
 * Boolean representing whether or not the user cheated is returned and extracted from an Intent.
 **************************************************************************************************/
    private val cheatLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        quizViewModel.isCheater =
            result.data?.getBooleanExtra(EXTRA_ANSWER_SHOWN, false) ?: false

        if(quizViewModel.isCheater) {
            quizViewModel.setQuestionCheatStatus()
        }
    }
/***************************************************************************************************
 * Override [AppCompatActivity.onCreate] and perform initialization operations.
 **************************************************************************************************/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // --- logging onCreate
        Log.d(TAG, "onCreate(Bundle?) called")

        // --- inflate the chapter02_activity_main.xml resource using the View Binding
        binding = Ch07LayoutChallenge11Binding.inflate(layoutInflater)
        setContentView(binding.root)

        // --- Initializing the quizViewModel and logging its value in one line. The value is lazy initialized.
        Log.d(TAG, "Got a QuizViewModel: $quizViewModel")

        // --- set the on click listeners for the two buttons. When a button is clicked a corresponding
        // --- snackbar message is displayed to the user.
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
    
        // --- when the next button is clicked, currentIndex increments by 1.
        // --- it resets back to 0 if it has reached the end of the Questions list.
        binding.nextButton.setOnClickListener {
            quizViewModel.moveToNext()
            updateQuestions()
            setAnswerButtonState()
        }

        // --- Challenge #2: Add a Listener to the TextView
        // --- add "Next" feature to the TextView as on onClick Event
        binding.questionTextView.setOnClickListener{
            quizViewModel.moveToNext()
            updateQuestions()
            setAnswerButtonState()
        }

        // --- Challenge #3: Adding a Previous Button
        // --- add a previous button
        binding.previousButton.setOnClickListener {
            quizViewModel.moveToPrevious()
            updateQuestions()
            setAnswerButtonState()
        }

        // --- Listener for the cheat button. Displays the CheatActivity when clicked.
        // --- See link below for description of this@MainActivity usage
        // --- @link https://kotlinlang.org/docs/this-expressions.html#qualified-this
        binding.cheatButton.setOnClickListener {
            val answerIsTrue = quizViewModel.currentQuestionAnswer
            val intent = CheatActivity.newIntent(
                this@MainActivity,
                answerIsTrue,
                quizViewModel.didUserCheat()
            )
            //startActivity(intent)
            cheatLauncher.launch(intent)
        }

        // --- set the text in the text view when the view is created.
        this.updateQuestions()
        this.setAnswerButtonState()
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

        // --- set the correct toast based on whether or not the user cheated and whether the
        // --- answer is correct
        val messageId = when {
            quizViewModel.didUserCheat() -> R.string.judgement_toast
            userAnswer == correctAnswer -> {
                numCorrect++
                R.string.correct_toast
            }
            else -> R.string.incorrect_toast
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
} // END MainActivity
