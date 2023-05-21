package com.example.myapplication2

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//
class OnbordingActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onbording);
        var textView = findViewById<TextView>(R.id.skipText)
        textView.setOnClickListener{
            startActivity(Intent(this,SignUpActivity::class.java))
        }
    }

}