package com.artishevsky.loginscreenkata.domain.usecase

class ValidatePasswordUseCase {
    operator fun invoke(password: String): ValidationResult {
        if (password.length < MIN_LENGTH) return ValidationResult(
            successful = false,
            errorMessage = "The password needs to consist of at least $MIN_LENGTH characters!"
        )

        val containsLettersAndDigits = password.any { it.isDigit()} && password.any { it.isLetter() }
        return if (!containsLettersAndDigits) ValidationResult(
            successful = false,
            errorMessage = "The password needs to contain at least one letter and one digit"
        )
        else ValidationResult(true)
    }

    private companion object {
        private const val MIN_LENGTH = 8
    }
}