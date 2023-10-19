package com.example.appsproyecto.ui.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController= navController, startDestination= TabScreens.MainScreen.route){

    }
}