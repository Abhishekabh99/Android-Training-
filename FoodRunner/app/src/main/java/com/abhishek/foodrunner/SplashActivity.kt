package com.abhishek.foodrunner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.content.Intent
import android.content.SharedPreferences

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DELAY: Long = 2000 // 3 seconds delay
    //creating variable of type shared preerences to store shared preferences
    private lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //initialise shared preferences
        sharedPreferences = getSharedPreferences("FoodRunner Preferences", MODE_PRIVATE)
        // Set the initial value of "isLoggedIn" if SharedPreferences is empty
        if(!sharedPreferences.contains("isLoggedIn")) {
            val editor = sharedPreferences.edit()
            editor.putBoolean("isLoggedIn",false)
            editor.apply()
        }
        // Delay navigation to LoginPageActivity after SPLASH_DELAY milliseconds
        // Using a lambda expression with postDelayed
        window.decorView.postDelayed({
// Retrieve the value of "isLoggedIn" after setting the initial value
            val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
            // Navigate to the appropriate activity based on the login status
            val destination = if(isLoggedIn) HomeActivity::class.java else LoginPageActivity::class.java
            startActivity(Intent(this, destination))
            // Finish SplashActivity to prevent going back to it when pressing back button
            finish()
        }, SPLASH_DELAY)


    }
}