package com.example.notes.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.notes.Screen
import com.example.notes.data.DateManager
import com.example.notes.data.Note

//@Preview(showBackground = true)
//@Composable
//private fun HomePreview() {
//    val nts = remember { mutableListOf<Note>().apply {
//        addAll(notes)
//    } }
//    Home(notes = nts,null)
//}

@Composable
fun Home(
    notes: List<Note>,
    navController: NavHostController
) {
    val search = remember { mutableStateOf(false) }
    val  searchVal = remember { mutableStateOf("") }
    Scaffold (
        topBar = {
            AppBar(search = search, searchText = searchVal)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                navController.navigate(Screen.New.route) },
                containerColor = Color.Black
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(start = 16.dp, end = 16.dp)
        ) {
            if (notes.isEmpty() ){
                Text("No notes yet")
            }else{
                LazyColumn {
                    items  (notes){ note ->
                        Box(
                            modifier = Modifier.padding(top = 16.dp )
                        ){
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(10.dp))
                                    .fillMaxWidth()
                                    .height(120.dp)
                                    .background(note.toColor())
                                    .clickable(
                                        onClick = {
                                            navController.navigate(
                                                Screen.Edit.route.replace(
                                                    "{noteId}",
                                                    note.id.toString()
                                                )
                                            )
                                        }
                                    )

                            ){
                                if (note.title.isNotEmpty()) {

                                    Text(
                                        note.title.uppercase(), style = MaterialTheme.typography.titleMedium.copy(color = Color.Black),
                                        overflow = TextOverflow.Clip,
                                        maxLines = 1,
                                        modifier = Modifier
                                            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
                                            .align(Alignment.TopStart)
                                    )

                                }

                                Text(
                                    note.content, style = MaterialTheme.typography.bodyMedium.copy(color = Color.Black),
                                    overflow = TextOverflow.Ellipsis,
                                    maxLines = 3,
                                    modifier = Modifier
                                        .align(alignment = Alignment.CenterStart)
                                        .padding(
                                            start = 16.dp,
                                            end = 16.dp,
                                            top = if (note.title.isNotEmpty()) 0.dp else 16.dp
                                        )
                                )

                                Text(
                                    DateManager.formatNoteDate(note.createdAt),
                                    style = MaterialTheme.typography.bodySmall.copy(color = Color.Black),
                                    modifier = Modifier
                                        .padding(bottom = 10.dp, end = 16.dp)
                                        .align(
                                            alignment = Alignment.BottomEnd
                                        )
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}