package com.artishevsky.loginscreenkata

import org.junit.Test

internal class LoginScreenTest: BaseAndroidComposeTest() {

    @Test
    fun testLoginScreenIsDisplayed() {
        loginScreenRobot {
            isWelcomeLabelDisplayed()
        }
    }

}