package com.artishevsky.loginscreenkata.presentation

import org.junit.Assert.*
import org.junit.Test

class LoginViewModelTest {

    private val viewModel = LoginViewModel()

    @Test
    fun testDisplayInitialState() {
        assertEquals(LoginScreenState(), viewModel.state)
    }

}