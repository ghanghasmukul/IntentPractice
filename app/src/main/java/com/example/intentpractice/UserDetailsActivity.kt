package com.example.intentpractice

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UserDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        val usernameTV = findViewById<TextView>(R.id.usernameTV)
        val passwordTV = findViewById<TextView>(R.id.passwordTV)
        val sharedPreferences: SharedPreferences = this.getSharedPreferences(
            "shareware",
            Context.MODE_PRIVATE
        )
        val sharedUserName = sharedPreferences.getString("username", "").toString()
        val sharedPassword = sharedPreferences.getString("password","").toString()
        usernameTV.text = sharedUserName
        passwordTV.text = sharedPassword
        //val bundle: Bundle? = intent.extras
//        usernameTV.text = bundle?.get("Username").toString()
//        passwordTV.text = bundle?.get("Password").toString()

    }
}