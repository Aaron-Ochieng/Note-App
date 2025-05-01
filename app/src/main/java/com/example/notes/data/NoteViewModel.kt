package com.example.notes.data

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NoteViewModel : ViewModel() {
    private var _notes = MutableLiveData<List<Note>>()
    val notesList : LiveData<List<Note>> = _notes



    fun getNotes (){
        _notes.value = NoteManager.getNotes()
    }


    fun addNote (title: String, content: String){
        NoteManager.addNote(title,content)
        getNotes()
    }

    fun editNote(id: Int,title: String,content: String){
        NoteManager.editNote(id = id,title = title,content=content)
    }
    fun deleteNote (id: Int){
        NoteManager.deleteNote(id)
    }

    fun getNoteColor(noteId: Int) : Color{
        return NoteManager.getNoteColor(noteId)
    }
}