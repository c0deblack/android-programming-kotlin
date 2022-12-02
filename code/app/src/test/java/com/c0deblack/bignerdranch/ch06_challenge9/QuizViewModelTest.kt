package com.c0deblack.bignerdranch.ch06_challenge9

import androidx.lifecycle.SavedStateHandle
import org.junit.Assert.*
import org.junit.Test
import com.c0deblack.bignerdranch.androidprogramming.R

/***************************************************************************************************
 * Challenge #9: Asserting Yourself
 *      Use assertTrue() or assertFalse() to verify that
 *      QuizViewModel.currentQuestionAnswer behaves as expected.
 **************************************************************************************************/
class QuizViewModelTestChallenge9 {
/***************************************************************************************************
 * Test Answers to Questions 1 and 3
 *
 * Tests question 1, then moves to next two times. Then tests question 3.
 **************************************************************************************************/
    @Test
    fun currentAnswerMatchesQuestion(){
        val savedStateHandle = SavedStateHandle()
        val quizViewModel = QuizViewModel(savedStateHandle)
        assertEquals(R.string.question_australia, quizViewModel.currentQuestionText)
        assertTrue(quizViewModel.currentQuestionAnswer)
        quizViewModel.moveToNext()
        quizViewModel.moveToNext()
        assertEquals(R.string.question_mideast, quizViewModel.currentQuestionText)
        assertFalse(quizViewModel.currentQuestionAnswer)
    }
}