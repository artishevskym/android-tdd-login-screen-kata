package com.artishevsky.loginscreenkata.presentation

import com.artishevsky.loginscreenkata.base.BaseAndroidComposeTest
import org.junit.Test

internal class LoginScreenTest: BaseAndroidComposeTest() {

    @Test
    fun testLoginScreenIsDisplayed() {
        loginScreen {
            isEmailInputDisplayed()
            isPasswordInputDisplayed()
            isRepeatedPasswordInputDisplayed()
        }
    }

}