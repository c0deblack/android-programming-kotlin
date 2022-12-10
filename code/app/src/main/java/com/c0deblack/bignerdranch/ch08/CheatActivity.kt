package com.c0deblack.bignerdranch.ch08

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.c0deblack.bignerdranch.androidprogramming.R
import com.c0deblack.bignerdranch.androidprogramming.databinding.Ch08LayoutActivityCheatBinding

/***************************************************************************************************
 * Key Used For Launcher Intent
 * Used as a key in the intent's kay/value mappings.
 **************************************************************************************************/
const val EXTRA_ANSWER_IS_TRUE = "com.c0deblack.bignerdranch.qeoquiz.answer_is_true"
/***************************************************************************************************
 * Key Used For Returned Intent
 **************************************************************************************************/
const val EXTRA_ANSWER_SHOWN = "com.c0deblack.bignerdranch.qeoquiz.answer_shown"
/***************************************************************************************************
 * Challenge #10
 *      Key used to keep track of question number in the intent provided to CheatActivity.
 **************************************************************************************************/
const val EXTRA_IS_CHEATER = "com.c0deblack.bignerdranch.qeoquiz.is_cheater"
/***************************************************************************************************
 * Cheat Activity
 **************************************************************************************************/
/**
 * This activity is used to show the answer to the user.
 */
class CheatActivity : AppCompatActivity() {
/***************************************************************************************************
 * Declare ViewBinding
 **************************************************************************************************/
    private lateinit var binding: Ch08LayoutActivityCheatBinding
/***************************************************************************************************
 * Answered Flag
 * Used to determine if the user has cheated or not.
 **************************************************************************************************/
    private var answerIsTrue = false
/***************************************************************************************************
 * Cheat Flag
 * Keep track of cheat status across the MainActivity and CheatActivity.
 **************************************************************************************************/
private var isCheater = false
//=*************************************************************************************************
//= START onCreate
//=*************************************************************************************************
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Ch08LayoutActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)

    // --- return false if the EXTRA_ANSWER_IS_TRUE key isn't set
        answerIsTrue   = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)
        isCheater      = intent.getBooleanExtra(EXTRA_IS_CHEATER, false)

        binding.showAnswerButton.setOnClickListener {
            setCheatState()
        }

        if(isCheater){
            setCheatState()
        }
    }
//=*************************************************************************************************
//= END onCreate
//=*************************************************************************************************
/***************************************************************************************************
 * Generate New CheatActivity Intent
 * Create a new intent that can be used to launch the CheatActivity. Use a companion object to make
 * the function accessible statically. Keep logic related to CheatActivity contained within the
 * class.
 *
 * @link https://kotlinlang.org/docs/scope-functions.html
 **************************************************************************************************/
    companion object {
        fun newIntent(
            packageContext: Context,
            answerIsTrue: Boolean,
            isCheater: Boolean
        ): Intent {
            return Intent(packageContext, CheatActivity::class.java).apply {
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
                putExtra(EXTRA_IS_CHEATER, isCheater )
            }
        }
    }
/***************************************************************************************************
 * Send Return Intent
 * This function configures and sends back an Activity Result that includes an Intent with custom
 * data. The Intent tells the launcher activity whether or not the user clicked on the cheat button.
 **************************************************************************************************/
    private fun setAnswerShownResult(isAnswerShown: Boolean) {
        val data = Intent().apply {
            putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown)
        }
        setResult(RESULT_OK, data)
    }
/***************************************************************************************************
 * Show Answer
 * Show the correct answer to the user.
 **************************************************************************************************/
    private fun showAnswer(){
        val answerText = when {
            answerIsTrue -> R.string.true_button
            else -> R.string.false_button
        }
        binding.answerTextView.setText(answerText)
    }
/***************************************************************************************************
 * Set Cheat UI State
 **************************************************************************************************/
   private fun setCheatState(){
        binding.showAnswerButton.isEnabled = false
        showAnswer()
        setAnswerShownResult(true)
   }
}
