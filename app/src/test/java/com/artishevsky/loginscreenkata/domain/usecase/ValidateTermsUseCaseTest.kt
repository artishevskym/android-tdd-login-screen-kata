package com.artishevsky.loginscreenkata.domain.usecase

import org.junit.Assert.*
import org.junit.Test

class ValidateTermsUseCaseTest {

    private val validateTerms = ValidateTermsUseCase()

    @Test
    fun testNotAcceptedTerms() {
        val result = validateTerms(false)

        assertFalse(result.successful)
        assertEquals("The terms needs to be accepted!", result.errorMessage)
    }

    @Test
    fun testAcceptedTerms() {
        val result = validateTerms(true)

        assertTrue(result.successful)
        assertNull(result.errorMessage)
    }
}