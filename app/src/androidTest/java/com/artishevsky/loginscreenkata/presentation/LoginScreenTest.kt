package com.artishevsky.loginscreenkata.presentation

import com.artishevsky.loginscreenkata.base.BaseAndroidComposeTest
import org.junit.Test

internal class LoginScreenTest: BaseAndroidComposeTest() {

    @Test
    fun testLoginScreenIsDisplayed() {
        loginScreen {
            isEmailInputDisplayed()
            isPasswordInputDisplayed()
            isRepeatPasswordInputDisplayed()
            isAcceptTermsInputDisplayed()
            isSubmitButtonDisplayed()
        }
    }

    @Test
    fun testUserCanLoginSuccessfully() {
        loginScreen {
            typeEmail(USER_EMAIL)
            verifyEmail(USER_EMAIL)

            typePassword(USER_PASSWORD)
            clickPasswordVisibilityIcon()
            verifyPassword(USER_PASSWORD)

            typeRepeatPassword(USER_PASSWORD)
            clickRepeatPasswordVisibilityIcon()
            verifyRepeatPassword(USER_PASSWORD)

            clickAcceptTerms()
            verifyAcceptTermsChecked()

            clickSubmitButton()
            verifyLoginSuccessfully()
        }
    }

    private companion object TestData {
        private const val USER_EMAIL = "android@gmail.com"
        private const val USER_PASSWORD = "pass1234!"
    }
}