package com.tasty.recipesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tasty.recipesapp.databinding.ActivityMainBinding
import com.tasty.recipesapp.databinding.ActivitySplashBinding

class MainActivity : AppCompatActivity() {
    val binding = ActivityMainBinding.inflate(layoutInflater)


    override fun onCreate(savedInstanceState: Bundle?) {
        val result=intent.getStringExtra("message")
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}