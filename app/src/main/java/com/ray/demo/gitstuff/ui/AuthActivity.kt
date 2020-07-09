package com.ray.demo.gitstuff.ui

import android.os.Bundle
import android.util.Log
import com.ray.demo.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity: DaggerAppCompatActivity() {
     val TAG = "AuthActivity"

    @Inject
     lateinit var testingString:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        Log.d(TAG, "onCreate: Testing String is $testingString")
    }
}