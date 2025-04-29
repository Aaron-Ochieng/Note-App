package com.example.notes.data

import kotlinx.serialization.Serializable

@Serializable
data class Note(
    var id : Int,
    var title: String,
    var content : String,
    var createdAt : Long
)


val notes = listOf<Note>()