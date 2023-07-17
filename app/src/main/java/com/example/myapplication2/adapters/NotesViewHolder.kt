package com.example.myapplication2.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication2.R
import com.example.myapplication2.db.Note
import com.example.myapplication2.ui.RecycleClickListener
import java.text.SimpleDateFormat

class NotesViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(note: Note, listener: RecycleClickListener) {
        view.findViewById<TextView>(R.id.note_name).text = note.noteName
        view.findViewById<TextView>(R.id.date_note_text).text =
            SimpleDateFormat("dd/M/yyyy hh:mm").format(note.date)
        view.findViewById<TextView>(R.id.note_text).text = note.noteText
        itemView.setOnClickListener {
            //вызываем функцию интерфейса клика
            listener.onClick(note)
        }
        itemView.setOnLongClickListener {
            listener.onLongClick(note)
            true
        }
    }
}