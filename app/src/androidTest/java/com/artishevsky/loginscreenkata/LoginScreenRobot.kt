package com.artishevsky.loginscreenkata

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText

internal class LoginScreenRobot(
    baseAndroidComposeTest: BaseAndroidComposeTest
) : BaseScreenRobot(baseAndroidComposeTest.composeTestRule) {

    private val welcomeLabel by lazy { composeTestRule.onNode(hasText("Hello Android!")) }

    fun isWelcomeLabelDisplayed() = welcomeLabel.assertIsDisplayed()
}

internal fun BaseAndroidComposeTest.loginScreenRobot(
    func: LoginScreenRobot.() -> Unit
) = LoginScreenRobot(this).apply(func)