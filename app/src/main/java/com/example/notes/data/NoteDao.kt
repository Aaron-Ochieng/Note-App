package com.example.notes.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NoteDao {
    @Query("SELECT * FROM Note")
    fun getNotes () : LiveData<List<Note>>

    @Insert
    fun addNote (note : Note)

    @Update
    fun editNote (id : Int, title : String, content : String)

    @Delete
    fun deleteNote(id : Int)
}