package com.example.notes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route : String) {
    object Home : Screen("home")
    object New : Screen("new")
    object Edit : Screen("edit/{id}") {
        fun createRoute(id: Int) = "edit/$id"
    }
}

