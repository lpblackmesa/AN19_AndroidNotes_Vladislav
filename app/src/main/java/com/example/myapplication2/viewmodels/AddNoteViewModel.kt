package com.example.myapplication2.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication2.db.Note
import com.example.myapplication2.repository.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddNoteViewModel : ViewModel() {

    var noteSaved: (() -> Unit)? = null

    private val notesRepository = NotesRepository()

    fun addNote(note: Note) {
        //запускаем в IO потоке
        viewModelScope.launch(Dispatchers.IO) {
            notesRepository.addNote(note)
        }

        //noteSaved?.invoke()
    }
}