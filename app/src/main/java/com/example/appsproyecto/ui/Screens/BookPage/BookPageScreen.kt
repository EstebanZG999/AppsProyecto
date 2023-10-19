package com.example.appsproyecto.ui.Screens.BookPage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.example.appsproyecto.ui.theme.AppsProyectoTheme

class BookPageScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppsProyectoTheme {
                pageContent()
            }
        }
    }
}

@Composable
fun bookPageScreen(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        pageContent()
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    AppsProyectoTheme {
        pageContent()
    }
}

@Composable
fun pageContent(){

}