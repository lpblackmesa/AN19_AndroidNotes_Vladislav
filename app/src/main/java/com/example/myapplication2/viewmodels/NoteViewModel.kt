package com.example.myapplication2.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication2.db.Note
import com.example.myapplication2.repository.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class NoteViewModel:ViewModel() {
    //хранилище списка заметок
    val noteList = MutableLiveData<ArrayList<Note>>()
    //обьект-репозиторий с заметками
    val noteRep = NotesRepository()

//    fun getNotes() : ArrayList<Note> {
//        viewModelScope.launch(Dispatchers.IO) {
//            //postvalue потоконебезопасно, для работы не в ui потоке
//            noteList.value = noteRep.getNotes()
//        }
//        return noteRep.getNotes()
//    }

    fun getNotes() = viewModelScope.launch(Dispatchers.IO) {
        //postvalue потоконебезопасно, для работы не в ui потоке
        //для UI потока используется value
        noteList.postValue(noteRep.getNotes())
    }
    fun delNote (note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteRep.delNote(note)
            //обновляем view вызовом getNotes
            getNotes()
        }
    }
}