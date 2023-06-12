package com.example.myapplication2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication2.R
import com.example.myapplication2.repository.SharedPreferenceRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (SharedPreferenceRepository.isFirstOpen()) {
            supportFragmentManager.beginTransaction().replace(R.id.main_fragment, MainFragment()).commit()
        } else {
            supportFragmentManager.beginTransaction().replace(R.id.main_fragment, RecyclerViewFragment()).commit()
        }
    }
}
