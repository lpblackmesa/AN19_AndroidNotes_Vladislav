package com.example.myapplication2

import android.app.Application
import com.example.myapplication2.db.NotesDatabase
import com.example.myapplication2.repository.SharedPreferenceRepository

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        SharedPreferenceRepository.init(applicationContext)
        NotesDatabase.initDB(applicationContext)
    }
}