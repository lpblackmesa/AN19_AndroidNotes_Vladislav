package com.example.myapplication2.db

import androidx.room.*
import com.example.myapplication2.entity.NoteEntity


@Dao
interface NoteDao {
    //интерфейс запросов в базу данных
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: NoteEntity)

    @Delete
    fun delNote(note: NoteEntity)

    @Query("SELECT * FROM note")
    fun getNotes(): List<NoteEntity>

}