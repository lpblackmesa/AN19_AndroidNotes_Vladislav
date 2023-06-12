package com.example.myapplication2.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Note")
//класс для создания таблицы через room в базе данных с полями
data class NoteEntity  (
    @ColumnInfo("Note Name")
    val noteName : String,
    @ColumnInfo("Date")
    @PrimaryKey
    val date : Long,
    @ColumnInfo("Note Text")
    val noteText : String
)
