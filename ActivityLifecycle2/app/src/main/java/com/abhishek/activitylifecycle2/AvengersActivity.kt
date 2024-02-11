package com.abhishek.activitylifecycle2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AvengersActivity : AppCompatActivity() {

    var titleName: String? = "Avengers"
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Retrieve the title from SharedPreferences
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        setContentView(R.layout.scrollview_example)
        // Set the layout after retrieving the title
        titleName = sharedPreferences.getString("Title","The Avengers") // Set the layout after retrieving the title
        setContentView(R.layout.scrollview_example)
        // Set the activity title
        title = titleName

        val btnLogout = findViewById<Button>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            // Clear SharedPreferences to log out
            sharedPreferences.edit().clear().apply()
            val intent = Intent(this@AvengersActivity, LoginActivity::class.java)
            startActivity(intent)
            finish() // Finish AvengersActivity after logging out
        }
    }



}

