package com.example.myapplication2.db

import androidx.room.*
import com.example.myapplication2.entity.NoteEntity


@Dao
interface NoteDao {
    //интерфейс запросов в базу данных
    //функции suspend для работы их в потоке
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: NoteEntity)

    @Delete
    suspend fun delNote(note: NoteEntity)

    @Query("SELECT * FROM note")
    suspend fun getNotes(): List<NoteEntity>

}