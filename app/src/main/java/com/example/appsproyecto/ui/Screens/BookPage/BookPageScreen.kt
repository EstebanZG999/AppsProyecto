package com.example.appsproyecto.ui.Screens.BookPage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.appsproyecto.R
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

@Preview(showBackground = true, name = "Book Preview")
@Composable
fun BookPreview(){
    AppsProyectoTheme {
        pageContent()
    }
}

@Composable
fun pageContent(){
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)
    ){
        item{
            Box(modifier = Modifier
                .fillMaxSize()
                .height(220.dp)
                .background(Color.Red)){
                Image(
                    painter = painterResource(id = R.drawable.lightorange),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Row(modifier = Modifier.padding(horizontal = 15.dp)
                ) {
                    Column {
                        Box(modifier = Modifier
                            .padding(horizontal = 30.dp)
                            .width(140.dp)
                            .padding(top = 15.dp)
                            .padding(bottom = 15.dp)
                        ){
                            Image(
                                painter = painterResource(id = R.drawable.harrypotter1),
                                contentDescription = null,
                                contentScale = ContentScale.Fit
                            )
                        }
                    }
                    Column {
                        Box(modifier = Modifier
                            .width(120.dp)
                            .padding(top = 30.dp)
                            .background(Color.Black, shape = CircleShape.also { })
                            .height(120.dp)){
                        }
                        Column() {
                            Text(
                                text = "Book Owner",
                                modifier = Modifier.padding(top = 15.dp),
                                color = Color.White,
                                fontSize = 24.sp, fontStyle = FontStyle.Italic
                            )
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 15.dp),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .width(200.dp)
                            .height(50.dp)
                    ) {
                        Text(text = "SWAP")
                    }
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
                        text = "Book Name",
                        modifier = Modifier.padding(top = 5.dp),
                        color = Color.White,
                        fontSize = 45.sp, fontStyle = FontStyle.Italic
                    )
                    Text(
                        text = "Author",
                        modifier = Modifier.padding(top = 5.dp),
                        color = Color.White,
                        fontSize = 16.sp, fontStyle = FontStyle.Italic
                    )
                    Text(
                        text = "Book Review",
                        modifier = Modifier.padding(top = 5.dp),
                        color = Color.White,
                        fontSize = 16.sp, fontStyle = FontStyle.Italic
                    )
                    Text(
                        text = "Description",
                        modifier = Modifier.padding(top = 5.dp),
                        color = Color.White,
                        fontSize = 16.sp, fontStyle = FontStyle.Italic
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
                        text = "Swap Center",
                        modifier = Modifier.padding(top = 5.dp),
                        color = Color.White,
                        fontSize = 16.sp, fontStyle = FontStyle.Italic
                    )
                    Image(
                        painter = painterResource(id = R.drawable.googlemap),
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                }
            }

        }
    }
}