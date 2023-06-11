package com.example.myapplication2.ui

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication2.R

class SignUpActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
var loginText = findViewById<TextView>(R.id.loginText)
        loginText.setOnClickListener{
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}