package com.example.myapplication2.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.R
import com.example.myapplication2.db.Note

class NotesViewHolder(val view : View):RecyclerView.ViewHolder(view) {

    fun bind(note: Note){
    view.findViewById<TextView>(R.id.note_name).text = note.noteName
        view.findViewById<TextView>(R.id.date_note_text).text = note.date.toString()
        view.findViewById<TextView>(R.id.note_text).text = note.noteText
    }
}