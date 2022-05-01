package com.artishevsky.loginscreenkata.presentation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.onNodeWithTag
import com.artishevsky.loginscreenkata.base.BaseAndroidComposeTest
import com.artishevsky.loginscreenkata.base.BaseScreenRobot

internal class LoginScreenRobot(
    baseAndroidComposeTest: BaseAndroidComposeTest
) : BaseScreenRobot(baseAndroidComposeTest.composeTestRule) {

    private val welcomeLabel by lazy { composeTestRule.onNode(hasText("Hello Android!")) }
    private val emailInput by lazy { composeTestRule.onNodeWithTag("emailTextField") }

    fun isWelcomeLabelDisplayed() = welcomeLabel.assertIsDisplayed()
    fun isEmailInputDisplayed() = emailInput.assertIsDisplayed()
}

internal fun BaseAndroidComposeTest.loginScreen(
    func: LoginScreenRobot.() -> Unit
) = LoginScreenRobot(this).apply(func)