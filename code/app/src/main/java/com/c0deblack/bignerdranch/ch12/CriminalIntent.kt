package com.c0deblack.bignerdranch.ch12

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
        setContentView(R.layout.ch12_layout)
    }
}