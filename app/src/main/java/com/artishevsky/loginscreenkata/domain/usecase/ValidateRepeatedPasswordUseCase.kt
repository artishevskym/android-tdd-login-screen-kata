package com.artishevsky.loginscreenkata.domain.usecase

class ValidateRepeatedPasswordUseCase {
    operator fun invoke(password: String, repeatedPassword: String): ValidationResult {
        return if (password != repeatedPassword) ValidationResult(
            successful = false,
            errorMessage = "The passwords do not match!"
        )
        else ValidationResult(true)
    }
}