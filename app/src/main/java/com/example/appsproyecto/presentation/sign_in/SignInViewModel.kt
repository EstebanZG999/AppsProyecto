package com.example.appsproyecto.presentation.sign_in

import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SignInViewModel: ViewModel() {
    private val _state = MutableStateFlow(SignInState())
    val state = _state.asStateFlow()

    fun onSignInResult(result: SignInResult) {
        _state.update { it.copy(
            isSignInSuccessful = result.data != null,
            signInError = result.errorMessage
        ) }
    }

    fun resetState() {
        _state.update { SignInState() }
    }

    fun signInWithEmail(email: String, password: String) {
        // Aquí iría la lógica para iniciar sesión con Firebase o tu sistema de autenticación
        // Por ejemplo, con Firebase sería algo así:
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Inicio de sesión exitoso
                    _state.update { it.copy(isSignInSuccessful = true) }
                } else {
                    // Error en inicio de sesión
                    _state.update { it.copy(signInError = task.exception?.message) }
                }
            }
    }
}