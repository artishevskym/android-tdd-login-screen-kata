package com.artishevsky.loginscreenkata.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artishevsky.loginscreenkata.domain.usecase.ValidateEmailUseCase
import com.artishevsky.loginscreenkata.domain.usecase.ValidatePasswordUseCase
import com.artishevsky.loginscreenkata.domain.usecase.ValidateRepeatedPasswordUseCase
import com.artishevsky.loginscreenkata.domain.usecase.ValidateTermsUseCase
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val validateEmail: ValidateEmailUseCase = ValidateEmailUseCase(),
    private val validatePassword: ValidatePasswordUseCase = ValidatePasswordUseCase(),
    private val validateRepeatedPassword: ValidateRepeatedPasswordUseCase = ValidateRepeatedPasswordUseCase(),
    private val validateTerms: ValidateTermsUseCase = ValidateTermsUseCase()
) : ViewModel() {

    var state by mutableStateOf(LoginScreenState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: LoginScreenEvent) {
        when (event) {
            is LoginScreenEvent.AcceptTerms -> {
                state = state.copy(acceptedTerms = event.isAccepted)
            }
            is LoginScreenEvent.EmailChanged -> {
                state = state.copy(email = event.email)
            }
            is LoginScreenEvent.PasswordChanged -> {
                state = state.copy(password = event.password)
            }
            is LoginScreenEvent.RepeatedPasswordChanged -> {
                state = state.copy(repeatedPassword = event.repeatedPassword)
            }
            is LoginScreenEvent.Submit -> {
                submitData()
            }
        }
    }

    private fun submitData() {
        val emailResult = validateEmail(state.email)
        val passwordResult = validatePassword(state.password)
        val repeatedPasswordResult = validateRepeatedPassword(
            state.password, state.repeatedPassword
        )
        val termsResult = validateTerms(state.acceptedTerms)

        state = state.copy(
            emailError = emailResult.errorMessage,
            passwordError = passwordResult.errorMessage,
            repeatedPasswordError = repeatedPasswordResult.errorMessage,
            acceptedTermsError = termsResult.errorMessage
        )

        val hasError = listOf(
            emailResult,
            passwordResult,
            repeatedPasswordResult,
            termsResult
        ).any { !it.successful }

        if (hasError) {
            viewModelScope.launch {
                validationEventChannel.send(ValidationEvent.Failure)
            }
        } else {
            viewModelScope.launch {
                validationEventChannel.send(ValidationEvent.Success)
            }
        }
    }

    sealed class ValidationEvent {
        object Success: ValidationEvent()
        object Failure: ValidationEvent()
    }
}