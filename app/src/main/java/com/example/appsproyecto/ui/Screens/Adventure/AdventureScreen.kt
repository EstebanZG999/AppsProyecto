package com.example.appsproyecto.ui.Screens.Adventure

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.appsproyecto.R
import com.example.appsproyecto.ui.Navigation.AppNavigation
import com.example.appsproyecto.ui.theme.AppsProyectoTheme

class AdventureScreen : ComponentActivity() {
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
fun adventure(navController: NavController) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .height(100.dp)
                    .background(Color.Red),
                contentAlignment = Alignment.Center
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
                        .padding(1.dp)
                ) {
                    Icon(
                        Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White
                    )
                }

                Row(
                    modifier = Modifier
                        .padding(horizontal = 15.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 25.dp)
                            .height(140.dp)
                    ) {
                        Text(
                            text = "Adventure Books",
                            modifier = Modifier.padding(top = 20.dp),
                            color = Color.White,
                            fontSize = 41.sp,
                            fontStyle = FontStyle.Italic
                        )
                    }
                }
            }

            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    AdventureCard(imageId = R.drawable.mobydick, label = "Moby Dick")
                    AdventureCard(imageId = R.drawable.intothewild, label = "Into the Wild")
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    AdventureCard(imageId = R.drawable.kidnapped, label = "Kidnapped")
                    AdventureCard(imageId = R.drawable.whitefang, label = "White Fang")
                }
            }
        }
    }
}

@Composable
fun AdventureCard(imageId: Int, label: String) {
    Card(
        modifier = Modifier
            .width(185.dp)
            .height(240.dp)
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .size(180.dp)
                .padding(10.dp)
                .background(Color.White)
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = imageId),
                contentDescription = null
            )
        }

        Text(
            modifier = Modifier
                .padding(horizontal = 35.dp)
                .align(Alignment.CenterHorizontally),
            text = label,
            color = Color.Black,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@Preview(showBackground = true, name = "Adventure Preview")
fun AdventurePreview() {
    AppsProyectoTheme {
        adventure(navController = rememberNavController())
    }
}
