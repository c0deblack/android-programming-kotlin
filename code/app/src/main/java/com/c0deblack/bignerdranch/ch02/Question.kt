package com.c0deblack.bignerdranch.ch02

import androidx.annotation.StringRes
/***************************************************************************************************
 * A Kotlin Data Class is used to hold the App's data.
 **************************************************************************************************/
data class Question (@StringRes val textResID: Int, val answer : Boolean)