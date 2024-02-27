package com.tasty.recipesapp.activities
import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.tasty.recipesapp.R
import com.tasty.recipesapp.databinding.ActivityMainBinding
import com.tasty.recipesapp.ui.home.HomeFragment
import com.tasty.recipesapp.ui.recipies.RecipiesFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigation(binding)

    }
    override fun onStart() {
        super.onStart()
        Log.d(ContentValues.TAG, "onStart: MainActivity started.")
    }

    override fun onResume() {
        super.onResume()
        Log.d(ContentValues.TAG, "onResume: MainActivity resumed.")
    }

    override fun onPause() {
        super.onPause()
        Log.d(ContentValues.TAG, "onPause: MainActivity paused.")
    }

    override fun onStop() {
        super.onStop()
        Log.d(ContentValues.TAG, "onStop: MainActivity stopped.")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(ContentValues.TAG, "onDestroy: MainActivity destroyed.")
    }

    private fun setupNavigation(binding: ActivityMainBinding) {
        binding.bottomNavigation.setOnItemSelectedListener() {
            when (it.itemId) {
                R.id.homeFragment -> {
                    val navController = findNavController(R.id.nav_host_fragment)
                    navController.navigate(R.id.homeFragment)

                    true
                }
                R.id.recipesFragment -> {
                    val navController = findNavController(R.id.nav_host_fragment)
                    navController.navigate(R.id.recipesFragment)
                    true
                }
                R.id.profileFragment -> {
                    val navController = findNavController(R.id.nav_host_fragment)
                    navController.navigate(R.id.profileFragment)
                    true
                }
                else -> false

            }
        }
    }
}