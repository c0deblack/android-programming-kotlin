package com.c0deblack.bignerdranch.ch04

import androidx.annotation.StringRes
/***************************************************************************************************
 * A Kotlin Data Class is used to hold the App's data.
 **************************************************************************************************/
data class Question (
    @StringRes val textResId: Int,
    val answer : Boolean,
    var isAnswered: Boolean = false)
