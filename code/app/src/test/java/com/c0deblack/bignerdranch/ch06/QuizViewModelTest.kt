package com.c0deblack.bignerdranch.ch06

import androidx.lifecycle.SavedStateHandle
import org.junit.Assert.*
import org.junit.Test
import com.c0deblack.bignerdranch.androidprogramming.R

/***************************************************************************************************
 * Tests involving the QuizViewModel.
 **************************************************************************************************/
class QuizViewModelTest {
/***************************************************************************************************
 * Test that first question shows correctly.
 *
 * The QuizViewModel must not use or depend on any parts of the Android
 * framework. This includes logging. Otherwise a test double would be
 * required.
 **************************************************************************************************/
    @Test
    fun provideExpectedQuestionText(){
        val savedStateHandle = SavedStateHandle()
        val quizViewModel = QuizViewModel(savedStateHandle)
        assertEquals(R.string.question_australia, quizViewModel.currentQuestionText)
    }
/***************************************************************************************************
 * Test that questions wrap properly.
 *
 * Test whether the questions properly wrap when the next operation is called.
 * The current index is passed to the model via the savedStateHandle.
 **************************************************************************************************/
    @Test
    fun wrapsAroundQuestionBank(){
        val savedStateHandle = SavedStateHandle(mapOf(CURRENT_INDEX_KEY to 5))
        val quizViewModel = QuizViewModel(savedStateHandle)
        assertEquals(R.string.question_asia, quizViewModel.currentQuestionText)
        quizViewModel.moveToNext()
        assertEquals(R.string.question_australia, quizViewModel.currentQuestionText)
    }
}