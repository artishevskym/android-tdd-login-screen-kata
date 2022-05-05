package com.artishevsky.loginscreenkata.domain.usecase

import org.junit.Assert.*
import org.junit.Test

class ValidatePasswordUseCaseTest {

    private val validatePassword = ValidatePasswordUseCase()

    @Test
    fun testMinimumLength() {
        val result = validatePassword("1234567")

        assertFalse(result.successful)
        assertEquals("The password needs to consist of at least 8 characters!", result.errorMessage)
    }

    @Test
    fun testOnlyLetters() {
        val result = validatePassword("abababab")

        assertFalse(result.successful)
        assertEquals("The password needs to contain at least one letter and one digit", result.errorMessage)
    }

    @Test
    fun testOnlyDigits() {
        val result = validatePassword("12345678")

        assertFalse(result.successful)
        assertEquals("The password needs to contain at least one letter and one digit", result.errorMessage)
    }

    @Test
    fun testValidPassword() {
        val result = validatePassword("abababa1")

        assertTrue(result.successful)
        assertNull(result.errorMessage)
    }
}