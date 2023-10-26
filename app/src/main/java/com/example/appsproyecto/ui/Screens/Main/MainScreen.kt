package com.example.appsproyecto.ui.Screens.Main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.appsproyecto.ui.theme.AppsProyectoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppsProyectoTheme {
                AppNavigation()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun principal(navController: NavController) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
    ){
        item {
            Box(modifier = Modifier
                .fillMaxSize()
                .height(200.dp)
                .background(Color.Red)){
                Image(
                    painter = painterResource(id = R.drawable.lightorange),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Row(modifier = Modifier.padding(horizontal = 15.dp)) {
                    Box(modifier = Modifier
                        .width(190.dp)
                        .padding(top = 25.dp)
                        .padding(horizontal = 25.dp)
                        .background(Color.Black, shape = CircleShape.also { })
                        .height(140.dp)){
                    }
                    Column() {
                        Text(
                            text = "Hello again, Username",
                            modifier = Modifier.padding(top = 40.dp),
                            color = Color.White,
                            fontSize = 24.sp, fontStyle = FontStyle.Italic
                        )
                        
                        Button(onClick = { navController.navigate(route = TabScreens.ProfileScreen.route) }) {
                            Text(text = "Edit Profile")
                        }
                    }

                }

            }

            Box(modifier = Modifier.padding(10.dp)){
                Text(text = "Close to you",color = Color.White,fontSize = 24.sp)
            }
            
            LazyRow(){
                item {
                    Card(modifier = Modifier
                        .width(185.dp)
                        .height(240.dp)
                        .padding(10.dp)) {

                        Column() {
                            Box(modifier = Modifier
                                .size(180.dp)
                                .padding(10.dp)
                                .background(Color.White)){
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painterResource(id = R.drawable.greatgatsby),
                                    contentDescription = null)

                            }

                            Text(
                                modifier = Modifier.padding(horizontal = 12.dp),
                                text = "The Great Gatsby",
                                color = Color.Black,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold)

                        }
                    }

                    Card(modifier = Modifier
                        .width(185.dp)
                        .height(240.dp)
                        .padding(10.dp)) {

                        Column() {
                            Box(modifier = Modifier
                                .size(180.dp)
                                .padding(10.dp)
                                .background(Color.White)
                                .clickable { navController.navigate(route = TabScreens.BookPageScreen.route) }){
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painterResource(id = R.drawable.harrypotter1),
                                    contentDescription = null)

                            }

                            Text(
                                modifier = Modifier.padding(horizontal = 30.dp),
                                text = "Harry Potter",
                                color = Color.Black,
                                fontSize = 17.sp,
                                fontWeight = FontWeight.Bold)

                        }
                    }

                    Card(modifier = Modifier
                        .width(185.dp)
                        .height(240.dp)
                        .padding(10.dp)) {

                        Column() {
                            Box(modifier = Modifier
                                .size(180.dp)
                                .padding(10.dp)
                                .background(Color.White)){
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painterResource(id = R.drawable.mobydick),
                                    contentDescription = null)

                            }

                            Text(
                                modifier = Modifier.padding(horizontal = 35.dp),
                                text = "Moby Dick",
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold)

                        }
                    }
                }
            }
            var searchText by remember { mutableStateOf(TextFieldValue()) }

            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                label = { Text("Buscar", color = Color.White) },
                singleLine = true,
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Ícono de búsqueda", tint = Color.White) },
                textStyle = TextStyle(color = Color.White),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    cursorColor = Color.White,
                    focusedLeadingIconColor = Color.White,
                    focusedBorderColor = Color.White,
                    unfocusedBorderColor = Color.White
                ),
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .fillMaxWidth()
            )
            
            Column() {
                Row() {
                    Column() {
                        Card(modifier = Modifier
                            .width(185.dp)
                            .height(240.dp)
                            .padding(10.dp)
                            .clickable { navController.navigate(route = TabScreens.AdventureScreen.route) }) {
                            Box(modifier = Modifier
                                .size(180.dp)
                                .padding(10.dp)
                                .background(Color.White)){
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painterResource(id = R.drawable.adventure2),
                                    contentDescription = null)

                            }

                            Text(
                                modifier = Modifier.padding(horizontal = 35.dp),
                                text = "Adventure",
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold)

                        }

                    }

                    Column() {
                        Card(modifier = Modifier
                            .width(185.dp)
                            .height(240.dp)
                            .padding(10.dp)
                            .clickable { navController.navigate(route = TabScreens.HorrorScreen.route) }) {
                        Box(modifier = Modifier
                                .size(180.dp)
                                .padding(10.dp)
                                .background(Color.White)){
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painterResource(id = R.drawable.horror),
                                    contentDescription = null)

                            }

                            Text(
                                modifier = Modifier.padding(horizontal = 50.dp),
                                text = "Horror",
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold)

                        }

                    }


                }

                Row() {
                    Column() {
                        Card(modifier = Modifier
                            .width(185.dp)
                            .height(240.dp)
                            .padding(10.dp)
                            .clickable { navController.navigate(route = TabScreens.ActionScreen.route) }) {
                        Box(modifier = Modifier
                                .size(180.dp)
                                .padding(10.dp)
                                .background(Color.White)){
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painterResource(id = R.drawable.ironman),
                                    contentDescription = null)

                            }

                            Text(
                                modifier = Modifier.padding(horizontal = 50.dp),
                                text = "Action",
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold)

                        }

                    }

                    Column() {
                        Card(modifier = Modifier
                            .width(185.dp)
                            .height(240.dp)
                            .padding(10.dp)
                            .clickable { navController.navigate(route = TabScreens.RomanceScreen.route) }) {
                        Box(modifier = Modifier
                                .size(180.dp)
                                .padding(10.dp)
                                .background(Color.White)){
                                Image(
                                    modifier = Modifier.fillMaxSize(),
                                    painter = painterResource(id = R.drawable.romance),
                                    contentDescription = null)

                            }

                            Text(
                                modifier = Modifier.padding(horizontal = 43.dp),
                                text = "Romance",
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold)

                        }

                    }


                }
                
            }
        }
    }

}

@Composable
@Preview(showBackground = true, name = "Principal Preview")
fun PrincipalPreview() {
    AppsProyectoTheme {
        principal(navController = rememberNavController())
    }
}
