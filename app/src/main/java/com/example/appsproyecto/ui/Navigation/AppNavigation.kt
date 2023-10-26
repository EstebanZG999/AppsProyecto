package com.example.appsproyecto.ui.Navigation

import ChatContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appsproyecto.ui.Screens.BookPage.pageContent
import com.example.appsproyecto.ui.Screens.Main.principal
import com.example.appsproyecto.ui.Screens.ProfileScreen.profile


@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(navController= navController, startDestination= TabScreens.MainScreen.route){
        composable(route = TabScreens.MainScreen.route){
            principal(navController)
        }
        composable(route = TabScreens.BookPageScreen.route){
            pageContent(navController)
        }
        composable(route = TabScreens.ChatScreen.route){
            ChatContent(navController)
        }
        composable(route = TabScreens.ProfileScreen.route){
            profile(navController)
        }
    }
}