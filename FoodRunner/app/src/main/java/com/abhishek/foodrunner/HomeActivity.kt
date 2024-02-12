package com.abhishek.foodrunner

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {

    //UI elements
    lateinit var btnLogOut: Button
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
//initialising shared preferences
        sharedPreferences = getSharedPreferences("FoodRunner Preferences", MODE_PRIVATE)
        //initialise UI elements
        btnLogOut = findViewById(R.id.btnLogOut)

        btnLogOut.setOnClickListener {
            //removing variable from shared preferences
            val editor = sharedPreferences.edit()
            editor.remove("isLoggedIn")
            editor.apply()

            //Navigating to login Page
            val intent = Intent(this,LoginPageActivity::class.java)
            startActivity(intent)
            finish() // finish HomePage AActivity

        }
    }
}