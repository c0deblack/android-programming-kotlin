package com.c0deblack.bignerdranch.ch12

import android.app.Application
import android.util.Log

/***************************************************************************************************
 * Access app lifecycle with a separate class.
 * This class is used to perform setup operations when the app starts without having to worry about
 * state being lost during configuration changes. The class maintains global application state.
 * * Overrides [Application].
 **************************************************************************************************/
class CriminalIntentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        CrimeRepository.initialize(this)
        Log.d("CriminalIntentApplication", "onCreate() finished")
    }
}