package com.artishevsky.loginscreenkata.presentation

import androidx.compose.ui.test.*
import com.artishevsky.loginscreenkata.R
import com.artishevsky.loginscreenkata.base.BaseAndroidComposeTest
import com.artishevsky.loginscreenkata.base.BaseScreenRobot
import com.artishevsky.loginscreenkata.presentation.LoginScreenTag.TAG_ACCEPT_TERMS_CHECKBOX
import com.artishevsky.loginscreenkata.presentation.LoginScreenTag.TAG_ACCEPT_TERMS_TEXT
import com.artishevsky.loginscreenkata.presentation.LoginScreenTag.TAG_EMAIL_TEXT_FIELD
import com.artishevsky.loginscreenkata.presentation.LoginScreenTag.TAG_PASSWORD_TEXT_FIELD
import com.artishevsky.loginscreenkata.presentation.LoginScreenTag.TAG_PASSWORD_VISIBILITY_ICON
import com.artishevsky.loginscreenkata.presentation.LoginScreenTag.TAG_REPEAT_PASSWORD_TEXT_FIELD
import com.artishevsky.loginscreenkata.presentation.LoginScreenTag.TAG_REPEAT_PASSWORD_VISIBILITY_ICON
import com.artishevsky.loginscreenkata.presentation.LoginScreenTag.TAG_SUBMIT_BUTTON

internal class LoginScreenRobot(
    baseAndroidComposeTest: BaseAndroidComposeTest
) : BaseScreenRobot(baseAndroidComposeTest.composeTestRule) {

    private val emailInput
            by lazy { composeTestRule.onNodeWithTag(TAG_EMAIL_TEXT_FIELD) }
    private val passwordInput
            by lazy { composeTestRule.onNodeWithTag(TAG_PASSWORD_TEXT_FIELD) }
    private val repeatPasswordInput
            by lazy { composeTestRule.onNodeWithTag(TAG_REPEAT_PASSWORD_TEXT_FIELD) }
    private val acceptTermsCheckbox
            by lazy { composeTestRule.onNodeWithTag(TAG_ACCEPT_TERMS_CHECKBOX) }
    private val acceptTermsText
            by lazy { composeTestRule.onNodeWithTag(TAG_ACCEPT_TERMS_TEXT) }
    private val submitButton
            by lazy { composeTestRule.onNodeWithTag(TAG_SUBMIT_BUTTON) }
    private val loginResultText
            by lazy { composeTestRule.onNodeWithText(getString(R.string.login_result_success_text)) }
    private val passwordVisibilityIcon
            by lazy { composeTestRule.onNodeWithTag(TAG_PASSWORD_VISIBILITY_ICON) }
    private val repeatPasswordVisibilityIcon
            by lazy { composeTestRule.onNodeWithTag(TAG_REPEAT_PASSWORD_VISIBILITY_ICON) }

    fun isEmailInputDisplayed() = emailInput
        .assertIsDisplayed()
        .assert(hasText(getString(R.string.login_email_input_text)))

    fun isPasswordInputDisplayed() = passwordInput
        .assertIsDisplayed()
        .assert(hasText(getString(R.string.login_password_input_text)))

    fun isRepeatPasswordInputDisplayed() = repeatPasswordInput
        .assertIsDisplayed()
        .assert(hasText(getString(R.string.login_repeat_password_input_text)))

    fun isAcceptTermsInputDisplayed() = acceptTermsCheckbox
        .assertIsDisplayed()
        .also {
            acceptTermsText
                .assertIsDisplayed()
                .assert(hasText(getString(R.string.login_accept_terms_text)))
        }

    fun isSubmitButtonDisplayed() = submitButton
        .assertIsDisplayed()
        .assert(hasText(getString(R.string.login_submit_button_text)))

    fun typeEmail(email: String) = emailInput.performTextReplacement(email)

    fun typePassword(password: String) = passwordInput.performTextReplacement(password)

    fun typeRepeatPassword(password: String) = repeatPasswordInput.performTextReplacement(password)

    fun clickAcceptTerms() = acceptTermsCheckbox.performClick()

    fun clickSubmitButton() = submitButton.performClick()
    fun verifyEmail(email: String) = emailInput.assertTextEquals(email)
    fun verifyPassword(password: String) = passwordInput.assertTextEquals(password)
    fun verifyRepeatPassword(password: String) =
        repeatPasswordInput.assertTextEquals(password)

    fun verifyAcceptTermsChecked() = acceptTermsCheckbox.assertIsOn()
    fun verifyLoginSuccessfully() = loginResultText.assertIsDisplayed()
    fun clickPasswordVisibilityIcon() = passwordVisibilityIcon.performClick()
    fun clickRepeatPasswordVisibilityIcon() = repeatPasswordVisibilityIcon.performClick()
}

internal fun BaseAndroidComposeTest.loginScreen(
    func: LoginScreenRobot.() -> Unit
) = LoginScreenRobot(this).apply(func)