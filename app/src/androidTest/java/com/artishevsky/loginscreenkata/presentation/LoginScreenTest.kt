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
            isSubmitEnabled(false)

            typeEmail(USER_EMAIL)
            isEmailTextDisplayed(USER_EMAIL)

            typePassword(USER_PASSWORD)
            isPasswordTextDisplayed(USER_PASSWORD)

            confirmPassword(USER_PASSWORD)
            isConfirmPasswordTextDisplayed(USER_PASSWORD)

            acceptTerms()
            isAcceptTermsChecked()

            isSubmitEnabled(true)

            submit()
            isFormSubmittedTextDisplayed()
        }
    }

    private companion object TestData {
        private const val USER_EMAIL = "android@gmail.com"
        private const val USER_PASSWORD = "pass1234!"
    }
}