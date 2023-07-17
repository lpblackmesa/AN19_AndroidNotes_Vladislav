package com.example.myapplication2.repository

import com.example.myapplication2.db.AppDataBase
import com.example.myapplication2.db.Note
import com.example.myapplication2.db.NotesDatabase
import com.example.myapplication2.entity.NoteEntity

class NotesRepository {

   suspend fun getNotes(): ArrayList<Note> {
        return (NotesDatabase.noteDao?.getNotes()?.map {
            Note(
                it.noteName ,
                it.date ,
                it.noteText
            )
        } as? ArrayList<Note>) ?: arrayListOf()
    }

   suspend fun addNote(note: Note) : Boolean{
        NotesDatabase.noteDao?.insertNote(NoteEntity(
            note.noteName,
            note.date,
            note.noteText
        ))
        return true
    }

   suspend fun delNote(note : Note ) {
        NotesDatabase.noteDao?.delNote(NoteEntity(
            note.noteName,
            note.date,
            note.noteText
        ))
    }
}