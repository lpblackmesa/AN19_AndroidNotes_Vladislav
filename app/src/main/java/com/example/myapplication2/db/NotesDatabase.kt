package com.example.myapplication2.db

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

object NotesDatabase {

    var noteDao: NoteDao? = null

    private var db: AppDataBase? = null

    //инициализация базы данных
fun initDB(context : Context) {
    db = Room.databaseBuilder(context, AppDataBase::class.java, "data-base")
        .allowMainThreadQueries()
        .build()
    noteDao = db?.getNoteDao()
}
    val notesArray = arrayListOf<Note>(
        Note("note1",12121221,"NoteText1"),
        Note("note2",12121221,"NoteText2"),
        Note("note3",12121221,"NoteText3"),
        Note("note4",12121221,"NoteText4"),
        Note("note5",12121221,"NoteText5"),
        Note("note6",12121221,"NoteText6")
    )

    }
