package com.artishevsky.loginscreenkata.domain.usecase

import org.junit.Assert.*
import org.junit.Test

class ValidateRepeatedPasswordUseCaseTest {

    private val validateRepeatedPassword = ValidateRepeatedPasswordUseCase()

    @Test
    fun testNotMatchingPasswords() {
        val result = validateRepeatedPassword("abababab", "abababab1")

        assertFalse(result.successful)
        assertEquals("The passwords do not match!", result.errorMessage)
    }

    @Test
    fun testMatchingPasswords() {
        val result = validateRepeatedPassword("abababab", "abababab")

        assertTrue(result.successful)
        assertNull(result.errorMessage)
    }
}