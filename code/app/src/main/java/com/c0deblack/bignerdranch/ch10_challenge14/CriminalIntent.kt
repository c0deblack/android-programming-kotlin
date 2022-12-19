package com.c0deblack.bignerdranch.ch10_challenge14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.c0deblack.bignerdranch.androidprogramming.R

/***************************************************************************************************
 * Main activity that contains a FragmentContainerView within its layout and is responsible for
 * displaying fragments.
 **************************************************************************************************/
class CriminalIntent : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ch10_layout_challenge14)
    }
}