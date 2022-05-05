package com.artishevsky.loginscreenkata.domain.usecase

class ValidateEmailUseCase {
    operator fun invoke(email: String): ValidationResult {
        return if (email.isBlank()) ValidationResult(
            successful = false,
            errorMessage = "The email cannot be blank!"
        )
        else if (!EMAIL_REGEX.matches(email)) ValidationResult(
            successful = false,
            errorMessage = "The email is not a valid email address!"
        )
        else ValidationResult(true)
    }

    private companion object {
        private val EMAIL_REGEX = "^[A-Za-z](.*)([@])(.+)(\\.)(.+)".toRegex()
    }
}