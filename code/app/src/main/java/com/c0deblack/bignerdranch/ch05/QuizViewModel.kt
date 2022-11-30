package com.c0deblack.bignerdranch.ch05

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.c0deblack.bignerdranch.androidprogramming.R

private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
/***************************************************************************************************
 * ViewModel for GeoQuiz
 * Holds the MainActivity's data between configuration changes.
 **************************************************************************************************/
class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    init {
        Log.d(TAG, "ViewModel instance created")
    }
    override fun onCleared(){
        super.onCleared()
        Log.d(TAG, "ViewModel instance is about to be destroyed")
    }
/***************************************************************************************************
 * Questions List
 * Each question is an instance of the Question data class. Each question keeps track of the string
 * resource ID and the answer ot he question.
 **************************************************************************************************/
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )
/***************************************************************************************************
 * Current Index
 * Keeps track of the currentIndex of the question in the list. The value is stored in the
 * savedStateHandle so that is survives process death.
 **************************************************************************************************/
   private var currentIndex
        get() = savedStateHandle[CURRENT_INDEX_KEY] ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)
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
        Log.d(TAG, "Updating question test", Exception())
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
        questionBank[currentIndex].isAnswered = true
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
}