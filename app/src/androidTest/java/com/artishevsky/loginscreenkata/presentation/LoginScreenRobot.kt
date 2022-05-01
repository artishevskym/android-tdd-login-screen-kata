package com.artishevsky.loginscreenkata.presentation

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.onNodeWithTag
import com.artishevsky.loginscreenkata.R
import com.artishevsky.loginscreenkata.base.BaseAndroidComposeTest
import com.artishevsky.loginscreenkata.base.BaseScreenRobot
import com.artishevsky.loginscreenkata.presentation.LoginScreenElement.EMAIL_TEXT_FIELD_TAG
import com.artishevsky.loginscreenkata.presentation.LoginScreenElement.PASSWORD_TEXT_FIELD_TAG
import com.artishevsky.loginscreenkata.presentation.LoginScreenElement.REPEAT_PASSWORD_TEXT_FIELD_TAG

internal class LoginScreenRobot(
    baseAndroidComposeTest: BaseAndroidComposeTest
) : BaseScreenRobot(baseAndroidComposeTest.composeTestRule) {

    private val emailInput
            by lazy { composeTestRule.onNodeWithTag(EMAIL_TEXT_FIELD_TAG) }
    private val passwordInput
            by lazy { composeTestRule.onNodeWithTag(PASSWORD_TEXT_FIELD_TAG) }
    private val repeatPasswordInput
            by lazy { composeTestRule.onNodeWithTag(REPEAT_PASSWORD_TEXT_FIELD_TAG) }

    fun isEmailInputDisplayed() = emailInput
        .assertIsDisplayed()
        .assert(hasText(getString(R.string.login_email_input_text)))

    fun isPasswordInputDisplayed() = passwordInput
        .assertIsDisplayed()
        .assert(hasText(getString(R.string.login_password_input_text)))

    fun isRepeatPasswordInputDisplayed() = repeatPasswordInput
        .assertIsDisplayed()
        .assert(hasText(getString(R.string.login_repeat_password_input_text)))
}

internal fun BaseAndroidComposeTest.loginScreen(
    func: LoginScreenRobot.() -> Unit
) = LoginScreenRobot(this).apply(func)