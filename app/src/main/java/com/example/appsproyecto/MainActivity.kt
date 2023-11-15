package com.example.appsproyecto

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import com.example.appsproyecto.presentation.sign_in.GoogleAuthUiClient
import com.example.appsproyecto.presentation.sign_in.SignInScreen
import com.example.appsproyecto.presentation.sign_in.SignInViewModel
import com.example.appsproyecto.ui.Navigation.AppNavigation
import com.example.appsproyecto.ui.Screens.LogIn.LogInScreen
import com.example.appsproyecto.ui.theme.AppsProyectoTheme
import com.google.android.gms.auth.api.identity.Identity
import com.google.firebase.auth.GoogleAuthProvider
import com.stevdzasan.onetap.OneTapSignInWithGoogle
import com.stevdzasan.onetap.rememberOneTapSignInState
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    /*private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppsProyectoTheme {
                //
                //AppNavigation();
                //

                //@Esteban Agrega Para enseñar el LogInScreen aquí, es lo último que me queda antes de perder la cabeza la verdad

                /*
                //Pre Cosas
                val oneTapSignInState = rememberOneTapSignInState()
                val authenticated = remember { mutableStateOf(false)}

                OneTapSignInWithGoogle(
                    state = oneTapSignInState,
                    clientId = "904961900221-nsi4pe7ids2099mosku80k9pr9rm1rt9.apps.googleusercontent.com",
                    onTokenIdReceived = { tokenId ->
                        authenticated.value = true
                        Log.d("MainScreen", tokenId)
                    },
                    onDialogDismissed = { message ->
                        Log.d("MainScreen", message)
                    }
                )

                //Compose Cosas
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Button(onClick = { oneTapSignInState.open() },
                        enabled = !oneTapSignInState.opened
                    ) {
                        Text(text = "Sign In")
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    if (authenticated.value){
                        Text(text = "Successfully Authenticated")
                    }
                }*/




                //Lo nuevo
                /*
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "sign_in" ){
                    composable("sign_in"){
                        val viewModel = viewModel<SignInViewModel>()
                        val state by viewModel.state.collectAsStateWithLifecycle() // Original "collectAsStateWithLifecycle()"
                        
                        val launcher = rememberLauncherForActivityResult(
                            contract = ActivityResultContracts.StartIntentSenderForResult(),
                            onResult = { result ->
                                if(result.resultCode == RESULT_OK){
                                    lifecycleScope.launch {
                                        val signInResult = googleAuthUiClient.signInWithIntent(
                                            intent = result.data ?: return@launch
                                        )
                                        viewModel.onSignInResult(signInResult)
                                    }
                                }

                            }
                        )
                        
                        LaunchedEffect(key1 = state.isSignInSuccessful){
                            if (state.isSignInSuccessful){
                                Toast.makeText(
                                    applicationContext,
                                    "Sign In Successful",
                                    Toast.LENGTH_LONG
                                ).show()
                            }
                        }

                        SignInScreen(
                            state = state,
                            onSignInClick = {
                                lifecycleScope.launch {
                                    val signInIntentSender = googleAuthUiClient.signIn()
                                    launcher.launch(
                                        IntentSenderRequest.Builder(
                                            signInIntentSender ?: return@launch
                                        ).build()
                                    )
                                }
                            }
                        )
                    }
                } */
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Applicacion() {
    AppsProyectoTheme {
        AppNavigation()

    }
}