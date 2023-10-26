package com.example.appsproyecto.ui.Screens.ProfileScreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appsproyecto.R
import com.example.appsproyecto.ui.Navigation.AppNavigation
import com.example.appsproyecto.ui.Navigation.TabScreens
import com.example.appsproyecto.ui.Screens.Main.principal
import com.example.appsproyecto.ui.theme.AppsProyectoTheme

class ProfileScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppsProyectoTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun profile(navController: NavController) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .height(310.dp)
                    .background(Color.Red),
                contentAlignment = Alignment.Center  // Centrar contenido en la Box
            ) {
                Image(
                    painter = painterResource(id = R.drawable.lightorange),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                // Botón para retroceder
                IconButton(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(16.dp)
                ) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally, // Alinear contenido en el eje horizontal
                    verticalArrangement = Arrangement.Center // Alinear contenido en el eje vertical
                ) {
                    Box(
                        modifier = Modifier
                            .background(Color.Black, shape = CircleShape)
                            .size(200.dp)
                    )
                    Text(
                        text = "Username",
                        modifier = Modifier.padding(top = 15.dp),
                        color = Color.White,
                        fontSize = 35.sp, fontStyle = FontStyle.Italic
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 15.dp)
                    .padding(horizontal = 15.dp),
            ){
                Column {
                    Text(
                        text = "Description",
                        modifier = Modifier.padding(top = 5.dp),
                        color = Color.White,
                        fontSize = 45.sp, fontStyle = FontStyle.Italic
                    )
                    Text(
                        text = "Username description",
                        modifier = Modifier.padding(top = 5.dp),
                        color = Color.White,
                        fontSize = 16.sp, fontStyle = FontStyle.Italic
                    )
                    Text(
                        text = "Favourite Book",
                        modifier = Modifier.padding(top = 5.dp),
                        color = Color.White,
                        fontSize = 45.sp, fontStyle = FontStyle.Italic
                    )
                    Text(
                        text = "Username's favourite book",
                        modifier = Modifier.padding(top = 5.dp),
                        color = Color.White,
                        fontSize = 16.sp, fontStyle = FontStyle.Italic
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, name = "Principal Preview")
fun ProfilePreview() {
    AppsProyectoTheme {
        profile(navController = rememberNavController())
    }
}