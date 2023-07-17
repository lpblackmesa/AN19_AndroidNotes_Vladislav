package com.example.myapplication2.ui

import com.example.myapplication2.db.Note

interface RecycleClickListener {
    fun onClick(note : Note)
    fun onLongClick(note : Note)
}