package com.example.myapplication2.repository

import com.example.myapplication2.db.Note
import com.example.myapplication2.db.NotesDatabase

class NotesRepository {

    fun getNotes() = NotesDatabase.notesArray

    fun addNote(note: Note) = NotesDatabase.notesArray.add(note)

    fun delNote(note : Note ) = NotesDatabase.notesArray.remove(note)
}