package com.abhishek.foodrunner

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class RegisterPageActivity : AppCompatActivity() {
    //Declaring UI Elements
lateinit var imgBackArrow: ImageView
lateinit var txtRegisterYourself: TextView
lateinit var etEnterYourName: EditText
lateinit var etEmailAddress: EditText
lateinit var etMobileNumber: EditText
lateinit var etDeliveryAddres: EditText
lateinit var etChoosePassword: EditText
lateinit var etConfirmPassword: EditText
lateinit var btnRegister: Button
//declare variable to store shared preferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)
        //initialise UI Elements
        imgBackArrow = findViewById(R.id.imgBackArrow)
        txtRegisterYourself = findViewById(R.id.txtRegisterYourself)
        etEnterYourName = findViewById(R.id.etEnterYourName)
        etEmailAddress = findViewById(R.id.etEmailAddress)
        etMobileNumber = findViewById(R.id.etMobileNumber)
        etDeliveryAddres= findViewById(R.id.etDeliveryAddress)
        etChoosePassword = findViewById(R.id.etChoosePassword)
        etConfirmPassword = findViewById(R.id.ConfirmPassword)
        btnRegister = findViewById(R.id.btnRegister)

    //set on click on register nutton
    btnRegister.setOnClickListener {
        //Retrieve Entered Information
        val name = etEnterYourName.text.toString()
        val emailAddress = etEmailAddress.text.toString()
        val mobileNumber = etMobileNumber.text.toString()
        val deliveryAddress = etDeliveryAddres.text.toString()
        val choosePassword = etChoosePassword.text.toString()
        val confirmPassword = etConfirmPassword.text.toString()

val intent = Intent(this,DisplayInfoActivity::class.java)
        //pass the entered information to display activity
        intent.putExtra("Name",name)
        intent.putExtra("Email",emailAddress)
        intent.putExtra("MobileNumber",mobileNumber)
        intent.putExtra("Address",deliveryAddress)
        intent.putExtra("ChoosePassword",choosePassword)
        intent.putExtra("ConfirmPassword",confirmPassword)
        startActivity(intent)

    }
    }
}