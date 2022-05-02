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

            typeEmail("android@gmail.com")
            typePassword("pass1234")
            confirmPassword("pass1234")
            acceptTerms()

            isSubmitEnabled(true)

            submit()
        }
    }

}