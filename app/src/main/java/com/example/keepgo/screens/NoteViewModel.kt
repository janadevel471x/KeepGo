package com.example.keepgo.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.keepgo.data.NoteData
import com.example.keepgo.model.Note

class NoteViewModel : ViewModel() {

    private var noteList = mutableStateListOf<Note>()

    init {
        noteList.addAll(
            NoteData().loadNotes()
        )
    }

    fun add(note : Note){
        noteList.add(note)
    }

    fun remove(note : Note){
        noteList.remove(note)
    }

    fun getAllNotes() : List<Note>{
        return noteList
    }
}