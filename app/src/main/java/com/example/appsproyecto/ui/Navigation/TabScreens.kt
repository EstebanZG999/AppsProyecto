package com.example.appsproyecto.ui.Navigation

sealed class TabScreens(val route: String){
    object MainScreen: TabScreens("main")
    object BookPageScreen: TabScreens("bookpage")
    object ChatScreen: TabScreens("chat")
}
