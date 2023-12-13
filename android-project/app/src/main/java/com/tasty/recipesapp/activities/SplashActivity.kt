package com.tasty.recipesapp.activities

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import com.tasty.recipesapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_splash)

        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)


        // Use a HandlerThread to create a background thread
        val handlerThread = HandlerThread("SplashHandlerThread", -10)
        handlerThread.start() // Create a Handler on the new HandlerThread
        val handler = Handler(handlerThread.looper)
        handler.postDelayed({
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(intent)
            finish() },
            2000)
        Log.d(TAG, "onCreate method called")
    }

    override fun onStart(){
        super.onStart()
        Log.d(TAG, "onStart method called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(ContentValues.TAG, "onResume: SplashActivity resumed.")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ContentValues.TAG, "onPause: SplashActivity paused.")
    }

    override fun onStop() {
        super.onStop()
        Log.d(ContentValues.TAG, "onStop: SplashActivity stopped.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ContentValues.TAG, "onDestroy: SplashActivity destroyed.")
    }



}