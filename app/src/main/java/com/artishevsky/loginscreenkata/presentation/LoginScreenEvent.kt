package com.artishevsky.loginscreenkata.presentation

sealed class LoginScreenEvent {
    data class EmailChanged(val email: String): LoginScreenEvent()
    data class PasswordChanged(val password: String): LoginScreenEvent()
    data class RepeatedPasswordChanged(val repeatedPassword: String) : LoginScreenEvent()
    data class AcceptTerms(val isAccepted: Boolean): LoginScreenEvent()
    object Submit: LoginScreenEvent()
}