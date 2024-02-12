package com.abhishek.foodrunner

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import javax.xml.validation.Validator

class LoginPageActivity : AppCompatActivity() {

    //Declaring UI Elements
lateinit var etMobileNumber: EditText
lateinit var etPassword: EditText
lateinit var btLogin: Button
lateinit var txtForgotPassword: TextView
lateinit var txtDontHaveAccount: TextView


    // Valid credentials
    val validMobileNumber = "1234"
    val validPassword = arrayOf("tony", "steve", "bruce", "wonder")

    //making a variable to store sharedPreferences to save login information
    lateinit var sharedPreferences: SharedPreferences

    //onCreate Activity State of the application
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)
        //Initialising UI Elements
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btLogin = findViewById(R.id.btLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtDontHaveAccount = findViewById(R.id.txtDontHaveAccount)
        //Initialising Shared Preferences
        sharedPreferences = getSharedPreferences("FoodRunner Preferences", MODE_PRIVATE)

        //login button function
        btLogin.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()

            if(mobileNumber == validMobileNumber && password in validPassword){
                //saving login state in shared preferences
                val editor = sharedPreferences.edit()
                editor.putBoolean("isLoggedIn",true)
                editor.apply()
                // navigating to home screen
                val intent = Intent(this@LoginPageActivity,HomeActivity::class.java)
                startActivity(intent)
                finish() //finish login activity
            }
            else {
                Toast.makeText(this@LoginPageActivity,"Invalid Credentials",Toast.LENGTH_LONG)
            }
        }
        txtForgotPassword.setOnClickListener {
val intent = Intent(this,ForgotPasswordActivity::class.java)
            startActivity(intent)

        }
        txtDontHaveAccount.setOnClickListener {
            val intent = Intent(this,RegisterPageActivity::class.java)
            startActivity(intent)
        }
    }
}