package com.abhishek.foodrunner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import org.w3c.dom.Text

class DisplayInfoActivity : AppCompatActivity() {
    //Declare UI elements
    lateinit var tvName: TextView
    lateinit var tvEmail: TextView
    lateinit var tvMobileNumber: TextView
    lateinit var tvAddress: TextView
    lateinit var tvChoosePassword: TextView
    lateinit var tvConfirmPassword: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_info)

        //Initialise UI Elements
        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        tvMobileNumber = findViewById(R.id.tvMobileNumber)
        tvAddress = findViewById(R.id.tvAddress)
        tvChoosePassword = findViewById(R.id.tvChoosePassword)
        tvConfirmPassword = findViewById(R.id.tvConfirmPassword)

        //Retrieve the passed information from intent extras
        val name = intent.getStringExtra("Name")
        val email = intent.getStringExtra("Email")
        val mobileNumber = intent.getStringExtra("MobileNumber")
        val address = intent.getStringExtra("Address")
        val choosePassword = intent.getStringExtra("ChoosePassword")
        val confirmPassword = intent.getStringExtra("ConfirmPassword")


        //Updating the UI elements with received information from last page
        tvName.text = "Name: $name"
        tvEmail.text = "Name: $email"
        tvMobileNumber.text = "Name: $mobileNumber"
        tvAddress.text = "Name: $address"
        tvChoosePassword.text = "ChoosePasword: $choosePassword"
        tvConfirmPassword.text = "ConfirmPassword: $confirmPassword"


    }
}