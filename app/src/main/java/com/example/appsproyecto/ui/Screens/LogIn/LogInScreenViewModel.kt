package com.example.appsproyecto.ui.Screens.LogIn

import android.net.wifi.hotspot2.pps.Credential
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.google.firebase.Firebase
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
//import com.google.firebase.auth.auth
import kotlinx.coroutines.launch

class LogInScreenViewModel: ViewModel() {
    private val auth: FirebaseAuth = Firebase.auth
    private val _loading = MutableLiveData(false)

    fun signInWithGoogleCredential(credential: AuthCredential, home: () -> Unit)
        = viewModelScope.launch {
            try {
                auth.signInWithCredential(credential)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d("MascotaFeliz", "Successful Google Log In")
                            home()
                        }
                    }
                    .addOnFailureListener {
                        Log.d("MascotaFeliz", "Failed Google Log in")
                    }
            }
            catch (ex:Exception){
                Log.d("Mascota Fezli", "Exception Google Log In: " + "${ex.localizedMessage}")
            }
        }
}