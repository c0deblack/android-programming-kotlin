package com.c0deblack.bignerdranch.ch08_challenge12

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.c0deblack.bignerdranch.androidprogramming.R

private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
const val QUESTION_BANK_KEY = "QUESTION_BANK_KEY"
const val IS_CHEATER = "IS_CHEATER"
/***************************************************************************************************
 * ViewModel for GeoQuiz
 * Holds the MainActivity's data between configuration changes.
 **************************************************************************************************/
class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    override fun onCleared(){
        super.onCleared()
        Log.d(TAG, "ViewModel instance is about to be destroyed")
    }
/***************************************************************************************************
 * Questions List
 * Each question is an instance of the Question data class. Each question keeps track of the string
 * resource ID and the answer ot he question.
 **************************************************************************************************/
    private var questionBank
        get() = savedStateHandle[QUESTION_BANK_KEY] ?: listOf(
            Question(R.string.question_australia, true),
            Question(R.string.question_oceans, true),
            Question(R.string.question_mideast, false),
            Question(R.string.question_africa, false),
            Question(R.string.question_americas, true),
            Question(R.string.question_asia, true)
        )
        set(value) = savedStateHandle.set(QUESTION_BANK_KEY, value)
/***************************************************************************************************
 * Current Index
 * Keeps track of the currentIndex of the question in the list. The value is stored in the
 * savedStateHandle so that is survives process death.
 **************************************************************************************************/
   var currentIndex
        get() = savedStateHandle[CURRENT_INDEX_KEY] ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)
/***************************************************************************************************
 * Cheater Status
 * Stores whether or not the user cheated. Values remains after config change and process death.
 **************************************************************************************************/
    var isCheater: Boolean
        get() = savedStateHandle[IS_CHEATER] ?: false
        set(value) = savedStateHandle.set(IS_CHEATER, value)
/***************************************************************************************************
 * Getters
 * Access various properties within the quizVeiwModel.
 **************************************************************************************************/
   val questionBankSize: Int
        get() = questionBank.size
   val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId
/***************************************************************************************************
 * Move To Next Question
 * Moves the currentIndex forward, wrapping around the list if it reaches the end.
 **************************************************************************************************/
    fun moveToNext(){
        currentIndex = (currentIndex + 1) % questionBank.size
    }
/***************************************************************************************************
 * Move To Previous Question
 * Moves the currentIndex backward, wrapping around the list if ti reaches the end.
 **************************************************************************************************/
    fun moveToPrevious(){
        currentIndex = if (currentIndex == 0){
            questionBank.size - 1
        } else {
            currentIndex - 1
        }
    }
/***************************************************************************************************
 * Check If All Answered
 * Checks the questionBank to see all questions are answered.
 **************************************************************************************************/
    fun isAllAnswered(): Boolean {
        for(question in questionBank){
            if(!question.isAnswered) return false
        }
        return true
    }
/***************************************************************************************************
 * Set Question Answer State
 * Challenge #4: Prevent Repeat Answers
 *      Sets a question as answered. The isAnswered property is later used to determine if the True
 *      and False buttons should be enabled.
 ***************************************************************************************************/
     fun setQuestionAnswered(){
        val temp = questionBank
        temp[currentIndex].isAnswered = true
        questionBank = temp
    }
/***************************************************************************************************
 * Check If A Question Is Answered
 * Challenge #4: Prevent Repeat Answers
 *      Checks if the question at the current index has already been answered. This function is used
 *      to figure out if the True/False answer buttons should be enabled.
 ***************************************************************************************************/
     fun checkIfAnswered() : Boolean {
        return questionBank[currentIndex].isAnswered
    }
/***************************************************************************************************
 * Check Current Question Cheat Status
 * Challenge #11: Tracking Cheat Status by Question
 *      Returns a Boolean indicating whether the user cheated on the current question or not.
 **************************************************************************************************/
    fun didUserCheat() : Boolean {
        return questionBank[currentIndex].cheated
    }
/***************************************************************************************************
 * Set Cheat Status for Current Question
 * Challenge #11: Tracking Cheat Status by Question
 *      Sets the cheat status per question.
 **************************************************************************************************/
    fun setQuestionCheatStatus() {
        val temp = questionBank
        temp[currentIndex].cheated = true
        questionBank = temp
    }
}