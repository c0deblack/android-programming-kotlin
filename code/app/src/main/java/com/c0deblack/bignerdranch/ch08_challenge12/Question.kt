package com.c0deblack.bignerdranch.ch08_challenge12

import androidx.annotation.StringRes
import java.io.Serializable

/***************************************************************************************************
 * A Kotlin Data Class is used to hold the App's data.
 **************************************************************************************************/
data class Question (
    @StringRes val textResId: Int,
    val answer : Boolean,
    var isAnswered: Boolean = false,
    var cheated: Boolean = false) : Serializable
