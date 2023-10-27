package com.tasty.recipesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tasty.recipesapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    val binding =ActivitySplashBinding.inflate(layoutInflater)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("SplashhActivity","SplashActivity onCreate() function called")
        setContentView(binding.root)
        binding.splashSartButton.setOnClickListener{
            Log.d("SplashhActivity","SplashActivity onCreate() function called")
            val intent =Intent(this,MainActivity::class.java)
            intent.putExtra("message",binding.splashActivityInput.text.toString())
            startActivity(intent)
        }
    }


    override fun onStart() {
        super.onStart()
        Log.d("SplashhActivity","SplashActivity onCreate() function called")

    }

    override fun onResume() {
        super.onResume()
        Log.d("SplashhActivity","SplashActivity onCreate() function called")

    }

    override fun onStop() {
        super.onStop()
        Log.d("SplashhActivity","SplashActivity onCreate() function called")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("SplashhActivity","SplashActivity onCreate() function called")


    }
}