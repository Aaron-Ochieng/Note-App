package com.example.notes

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route : String) {
    object Home : Screen("home")
    object New : Screen("new")
    object Edit : Screen("edit/{id}") {
        fun createRoute(id: Int) = "edit/$id"
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route){
    }
}