package com.c0deblack.bignerdranch.ch03_challenge4

import androidx.annotation.StringRes
/***************************************************************************************************
 * A Kotlin Data Class is used to hold the App's data.
 **************************************************************************************************/
data class Question (
    @StringRes val textResID: Int,
    val answer : Boolean,
    var isAnswered: Boolean = false)
