package com.example.intentpractice


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val username = findViewById<EditText>(R.id.usernameET)
        val password = findViewById<EditText>(R.id.passwordET)

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(
            "shareware",
            Context.MODE_PRIVATE
        )

        val firstLogin : String? = sharedPreferences.getString("username","")
        if (firstLogin != null) {
            if (firstLogin.isEmpty()){
                Toast.makeText(this,"Fresher",Toast.LENGTH_LONG).show()
            }else{
                intent = Intent(this, UserDetailsActivity::class.java)
                startActivity(intent)
            }
        }


                loginBtn.setOnClickListener() {
                    val usernameText = username.text
                    val passwordText = password.text
                    intent = Intent(this, UserDetailsActivity::class.java)
    //            intent.putExtra("Username", usernameText)
    //            intent.putExtra("Password", passwordText)
                    val editor: SharedPreferences.Editor = sharedPreferences.edit()
                    editor.putString("username",usernameText.toString())
                    editor.putString("password",passwordText.toString())

                    editor.apply()
                    startActivity(intent)
                }
        }
    }







