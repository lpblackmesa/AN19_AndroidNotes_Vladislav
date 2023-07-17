package com.example.myapplication2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.myapplication2.R
import com.example.myapplication2.repository.SharedPreferenceRepository
import com.example.myapplication2.ui.onboarding.SplashFragment

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //проверка на первое включение
        if (SharedPreferenceRepository.isFirstOpen()) {
            supportFragmentManager.beginTransaction().replace(R.id.main_fragment, SplashFragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .replace(R.id.main_fragment, RecyclerViewFragment()).commit()
        }
    }
}
