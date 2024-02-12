package com.abhishek.foodrunner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ForgotPasswordActivity : AppCompatActivity() {
    //Declareing UI Elements
    lateinit var etMobileNumber: EditText
    lateinit var etEmailAddress: EditText
    lateinit var btnNext: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        //Initialising UI Elements
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etEmailAddress = findViewById(R.id.etEmailAddress)
        btnNext = findViewById(R.id.btnNext)



        //setting click on Next Button
        btnNext.setOnClickListener {
            //Retrieving information from tags
            val mobileNumber = etMobileNumber.text.toString()
            val email = etEmailAddress.text.toString()
            val intent = Intent(this, DisplayInfoActivity2::class.java)
            //putting information to intent
            intent.putExtra("MobileNumber",mobileNumber)
            intent.putExtra("Email",email)

            startActivity(intent)
        }



    }
}