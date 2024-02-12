package com.abhishek.foodrunner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayInfoActivity2 : AppCompatActivity() {
    //Declare UI elements
    lateinit var tvMobileNumber: TextView
    lateinit var tvEmail: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_info_activity2)

        //Attaching declared Variable with tags in xml
        tvMobileNumber = findViewById(R.id.tvMobileNumber)
        tvEmail = findViewById(R.id.tvEmail)

        //Retrieving information from previous page
        val mobileNumber = intent.getStringExtra("MobileNumber")
        val email = intent.getStringExtra("Email")


        //Modifying xml according to received data
        tvMobileNumber.text = "Mobile Number: $mobileNumber"
        tvEmail.text = "Email: $email"
    }
}