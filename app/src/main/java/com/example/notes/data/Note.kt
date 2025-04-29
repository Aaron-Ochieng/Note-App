package com.example.notes.data

import java.time.LocalDateTime


data class Note(
    var id : Int,
    var title: String,
    var content : String,
    var createdAt : LocalDateTime
)


val notes = emptyList<Note>()