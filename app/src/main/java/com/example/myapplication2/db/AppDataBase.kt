package com.example.myapplication2.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication2.entity.NoteEntity

//Указываем класс Entity в базе и версию базы данных
@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDataBase :RoomDatabase(){

    //функция создания самой базы данных
    abstract fun getNoteDao(): NoteDao
}