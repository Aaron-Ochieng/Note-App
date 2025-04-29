package com.example.notes.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.notes.data.Note
import com.example.notes.data.notes

@Preview(showBackground = true)
@Composable
private fun HomePreview() {
    val nts = remember { mutableListOf<Note>().apply {
        addAll(notes)
    } }
    Home(notes = nts)
}

@Composable
fun Home(notes : List<Note>) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        if (notes.isEmpty() ){
            Text("No notes yet")
        }else{
            LazyColumn {
                items (notes){ note ->
                    Text(note.content, style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black))
                }
            }
        }
    }
}