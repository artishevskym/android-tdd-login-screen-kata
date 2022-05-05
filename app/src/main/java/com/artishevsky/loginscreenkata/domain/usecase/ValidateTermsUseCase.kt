package com.artishevsky.loginscreenkata.domain.usecase

class ValidateTermsUseCase {
    operator fun invoke(acceptedTerms: Boolean): ValidationResult {
        return if (!acceptedTerms) ValidationResult(
            successful = false,
            errorMessage = "The terms needs to be accepted!"
        )
        else ValidationResult(true)
    }
}