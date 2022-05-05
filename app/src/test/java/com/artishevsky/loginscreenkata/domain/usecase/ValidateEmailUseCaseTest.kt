package com.artishevsky.loginscreenkata.domain.usecase

import org.junit.Assert.*
import org.junit.Test

class ValidateEmailUseCaseTest {

    private val validateEmail = ValidateEmailUseCase()

    @Test
    fun testBlankEmails() {
        val blankEmails = listOf(
            "",
            "     "
        )
        blankEmails.forEach {
            val result = validateEmail(it)

            assertEquals(false, result.successful)
            assertEquals("The email cannot be blank!", result.errorMessage)
        }
    }

    @Test
    fun testInvalidEmails() {
        val invalidEmails = listOf(
            "john.smith@",
            "john@com",
            "john_01.",
            ".smith",
            "john@21_21com",
            "johnZ008",
            "_john008.com",
            "_john008@a.b.c"
        )
        invalidEmails.forEach {
            val result = validateEmail(it)

            assertEquals(false, result.successful)
            assertEquals("The email is not a valid email address!", result.errorMessage)
        }
    }

    @Test
    fun testValidEmails() {
        val validEmails = listOf(
            "john.smith@008.com",
            "john.008@a.b.c",
            "member@gmail.com"
        )
        validEmails.forEach {
            val result = validateEmail(it)

            assertTrue(result.successful)
            assertNull(result.errorMessage)
        }
    }
}