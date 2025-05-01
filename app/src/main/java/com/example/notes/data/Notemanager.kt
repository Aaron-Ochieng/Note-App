package com.example.notes.data



object NoteManager {
    private val notes = mutableListOf<Note>()

    fun getNotes () : List<Note>{
        return notes
    }


    fun addNote (title : String, content : String){
        notes.add(
            Note(
                id = System.currentTimeMillis().toInt(),
                title = title,
                content = content,
                createdAt = DateManager.now(),
                color = Note.fromColor()
            )
        )
    }

    fun editNote (id : Int, title : String, content : String){
        notes.forEach {
            if (it.id == id) {
                it.title = title
                it.content = content
            }
        }
    }
    fun deleteNote (id : Int){
        notes.removeIf{
            it.id == id
        }
    }
}