package com.example.appsproyecto.ui.Screens.LogIn

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.appsproyecto.R
import com.example.appsproyecto.ui.Navigation.TabScreens
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.GoogleApi
import com.google.firebase.auth.GoogleAuthProvider

@Composable
fun  LogInScreen(
    navController: NavController,
    viewModel: LogInScreenViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
){
    val showLoginForm = rememberSaveable {
        mutableStateOf(true)
    }
    val token = "904961900221-c1pktfr106ndibh0g7f37bb1m960mjki.apps.googleusercontent.com"
    val context = LocalContext.current
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts
            .StartActivityForResult()
    ){
        val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
        try {
            val account = task.getResult(ApiException::class.java)
            val credential = GoogleAuthProvider.getCredential(account.idToken, null)
            viewModel.signInWithGoogleCredential(credential) {
                navController.navigate(TabScreens.MainScreen.toString()) //cosa de navegar
            }
        }
        catch (ex:Exception) {
            Log.d("Mascota Feliz", "GoogleSignIn failed")
        }
    }
    Surface (modifier = Modifier.fillMaxSize()) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clip(RoundedCornerShape(10.dp))
                .clickable {
                           val opciones = GoogleSignInOptions.Builder(
                               GoogleSignInOptions.DEFAULT_SIGN_IN
                           )
                               .requestIdToken(token)
                               .requestEmail()
                               .build()
                    val googleSignInCliente = GoogleSignIn.getClient(context, opciones)
                    launcher.launch(googleSignInCliente.signInIntent)
                },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(id = R.drawable.ic_google) ,
                contentDescription = "GOOGLE LOG INNNNNN",
                 modifier = Modifier
                     .padding(10.dp)
                     .size(40.dp)
            )
            Text(text = "Login with Google",
                fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
            )
        }
    }
}