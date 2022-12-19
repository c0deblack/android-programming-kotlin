package com.c0deblack.bignerdranch.ch07

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.c0deblack.bignerdranch.androidprogramming.R
import com.c0deblack.bignerdranch.androidprogramming.databinding.Ch07LayoutActivityCheatBinding

// --- constants used as keys in intent bundle mappings
const val EXTRA_ANSWER_IS_TRUE = "com.c0deblack.bignerdranch.qeoquiz.answer_is_true"
const val EXTRA_ANSWER_SHOWN = "com.c0deblack.bignerdranch.qeoquiz.answer_shown"
/***************************************************************************************************
 * This activity is used to show the answer to the user.
 **************************************************************************************************/
class CheatActivity : AppCompatActivity() {
    // --- declare ViewBinding
    private lateinit var binding: Ch07LayoutActivityCheatBinding

    // --- used to determine if the user has cheated or not.
    private var answerIsTrue = false
/***************************************************************************************************
 * Initialize the [CheatActivity]. Overrides [AppCompatActivity.onCreate].
 **************************************************************************************************/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Ch07LayoutActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // --- return false if the EXTRA_ANSWER_IS_TRUE key isn't set
        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)

        binding.showAnswerButton.setOnClickListener {
            val answerText = when {
                answerIsTrue -> R.string.true_button
                else -> R.string.false_button
            }
            binding.answerTextView.setText(answerText)
            // --- return the result back to the launcher activity
            setAnswerShownResult(true)
        }
    } // END onCreate
/***************************************************************************************************
 * Generate New CheatActivity Intent
 * Create a new intent that can be used to launch the CheatActivity. Use a companion object to make
 * the function accessible statically. Keep logic related to CheatActivity contained within the
 * class.
 *
 * @link https://kotlinlang.org/docs/scope-functions.html
 **************************************************************************************************/
    companion object {
        fun newIntent(packageContext: Context, answerIsTrue: Boolean): Intent {
            return Intent(packageContext, CheatActivity::class.java).apply {
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
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
        setResult(Activity.RESULT_OK, data)
    }
} // END CheatActivity
