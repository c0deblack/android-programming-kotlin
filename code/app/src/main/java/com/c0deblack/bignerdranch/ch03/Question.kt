package com.c0deblack.bignerdranch.ch03

import androidx.annotation.StringRes
/***************************************************************************************************
 * A Kotlin Data Class is used to hold the App's data.
 *
 * This is the Model in the Model-View-Controller software architecture pattern.
 **************************************************************************************************/
data class Question (@StringRes val textResID: Int, val answer : Boolean) {

}