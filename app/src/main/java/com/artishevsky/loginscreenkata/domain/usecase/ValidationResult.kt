package com.artishevsky.loginscreenkata.domain.usecase

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: String? = null
)
