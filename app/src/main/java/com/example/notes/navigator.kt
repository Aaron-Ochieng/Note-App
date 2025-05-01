package com.example.notes

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.notes.data.NoteViewModel
import com.example.notes.screens.Home
import com.example.notes.screens.NewNote

sealed class Screen(val route : String) {
    object Home : Screen("home")
    object New : Screen("new")
    object Edit : Screen("edit")
}

@Composable
fun AppNavigation(viewModel: NoteViewModel) {
    val navController = rememberNavController()
    val notes =  viewModel.notesList.observeAsState(initial = null)

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ){
        composable(Screen.Home.route){
            Home(
                notes = notes.value ?: emptyList(),
                navController = navController
            )
        }
        composable(Screen.Edit.route) {

        }
        composable(Screen.New.route) {
            NewNote(navController = navController, viewModel = viewModel)
        }
    }
}