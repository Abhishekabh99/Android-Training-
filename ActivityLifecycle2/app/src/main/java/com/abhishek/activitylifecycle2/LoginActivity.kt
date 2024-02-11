package com.abhishek.activitylifecycle2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    // Declaring UI elements
    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgetPassword: TextView
    lateinit var txtRegister: TextView

    // Valid credentials
    val validMobileNumber = "1234"
    val validPassword = arrayOf("tony", "steve", "bruce", "wonder")

    // Shared Preferences for saving login status and title
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        // Check if the user is already logged in
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        setContentView(R.layout.activity_login)
        if(isLoggedIn){
            // If user is logged in, directly go to AvengersActivity
            val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
            startActivity(intent)
            finish()  // Finish login activity if user is already logged in
        }

        // Set title for the activity
        title = "Login"

        // Initialize UI elements
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgetPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)

        // Set OnClickListener for the login button
        btnLogin.setOnClickListener {
            // Get the entered mobile number and password
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            var nameOfAvenger = "Avenger"

            // Check if the mobile number is valid
            if (mobileNumber == validMobileNumber) {
                // Check the entered password against valid passwords
                when (password) {
                    validPassword[0] -> {
                        nameOfAvenger = "Iron Man"
                        savePreferences(nameOfAvenger)
                    }
                    validPassword[1] -> {
                        nameOfAvenger = "Captain America"
                        savePreferences(nameOfAvenger)
                    }
                    validPassword[2] -> {
                        nameOfAvenger = "The Hulk"
                        savePreferences(nameOfAvenger)
                    }
                    validPassword[3] -> {
                        nameOfAvenger = "The Avengers"
                        savePreferences(nameOfAvenger)
                    }
                }

                // Start AvengersActivity and pass the name of the Avenger
                val intent = Intent(this@LoginActivity, AvengersActivity::class.java)
                intent.putExtra("Name", nameOfAvenger)
                startActivity(intent)
                finish() // Finish login activity after starting AvengersActivity
            } else {
                // Show error message if credentials are incorrect
                Toast.makeText(this@LoginActivity, "Incorrect Credentials", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    // Function to save login status and title in SharedPreferences
    fun savePreferences(title: String) {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}
