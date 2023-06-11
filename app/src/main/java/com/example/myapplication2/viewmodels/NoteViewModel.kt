package com.example.myapplication2.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication2.db.Note
import com.example.myapplication2.repository.NotesRepository

class NoteViewModel:ViewModel() {
    //хранилище списка заметок
    val noteList = MutableLiveData<ArrayList<Note>>()
    //обьект-репозиторий с заметками
    val noteRep = NotesRepository()

    fun getNotes() : ArrayList<Note> {
        //postvalue потоконебезопасно, для работы не в ui потоке
         noteList.value = noteRep.getNotes()
        return noteRep.getNotes()

    }
}