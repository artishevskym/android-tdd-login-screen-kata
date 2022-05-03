package com.artishevsky.loginscreenkata.presentation

import androidx.compose.ui.test.*
import com.artishevsky.loginscreenkata.R
import com.artishevsky.loginscreenkata.base.BaseAndroidComposeTest
import com.artishevsky.loginscreenkata.base.BaseScreenRobot
import com.artishevsky.loginscreenkata.presentation.LoginScreenElement.ACCEPT_TERMS_CHECKBOX_TAG
import com.artishevsky.loginscreenkata.presentation.LoginScreenElement.ACCEPT_TERMS_TEXT_TAG
import com.artishevsky.loginscreenkata.presentation.LoginScreenElement.EMAIL_TEXT_FIELD_TAG
import com.artishevsky.loginscreenkata.presentation.LoginScreenElement.PASSWORD_TEXT_FIELD_TAG
import com.artishevsky.loginscreenkata.presentation.LoginScreenElement.REPEAT_PASSWORD_TEXT_FIELD_TAG
import com.artishevsky.loginscreenkata.presentation.LoginScreenElement.SUBMIT_BUTTON_TAG

internal class LoginScreenRobot(
    baseAndroidComposeTest: BaseAndroidComposeTest
) : BaseScreenRobot(baseAndroidComposeTest.composeTestRule) {

    private val emailInput
            by lazy { composeTestRule.onNodeWithTag(EMAIL_TEXT_FIELD_TAG) }
    private val passwordInput
            by lazy { composeTestRule.onNodeWithTag(PASSWORD_TEXT_FIELD_TAG) }
    private val repeatPasswordInput
            by lazy { composeTestRule.onNodeWithTag(REPEAT_PASSWORD_TEXT_FIELD_TAG) }
    private val acceptTermsCheckbox
            by lazy { composeTestRule.onNodeWithTag(ACCEPT_TERMS_CHECKBOX_TAG) }
    private val acceptTermsText
            by lazy { composeTestRule.onNodeWithTag(ACCEPT_TERMS_TEXT_TAG) }
    private val submitButton
            by lazy { composeTestRule.onNodeWithTag(SUBMIT_BUTTON_TAG) }
    private val formSubmittedText
            by lazy { composeTestRule.onNodeWithText(getString(R.string.login_form_submitted_text)) }

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

    fun isSubmitEnabled(enabled: Boolean) = submitButton.assert(
        if (enabled) isEnabled() else isNotEnabled()
    )

    fun typeEmail(email: String) = emailInput.performTextReplacement(email)

    fun typePassword(password: String) = passwordInput.performTextReplacement(password)

    fun confirmPassword(password: String) = repeatPasswordInput.performTextReplacement(password)

    fun acceptTerms() = acceptTermsCheckbox.performClick()

    fun submit() = submitButton.performClick()
    fun isEmailTextDisplayed(email: String) = emailInput.assertTextEquals(email)
    fun isPasswordTextDisplayed(password: String) = passwordInput.assertTextEquals(password)
    fun isConfirmPasswordTextDisplayed(password: String) =
        repeatPasswordInput.assertTextEquals(password)

    fun isAcceptTermsChecked() = acceptTermsCheckbox.assertIsOn()
    fun isFormSubmittedTextDisplayed() = formSubmittedText.assertIsDisplayed()
}

internal fun BaseAndroidComposeTest.loginScreen(
    func: LoginScreenRobot.() -> Unit
) = LoginScreenRobot(this).apply(func)