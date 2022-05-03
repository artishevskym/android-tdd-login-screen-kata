package com.artishevsky.loginscreenkata.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artishevsky.loginscreenkata.R
import com.artishevsky.loginscreenkata.presentation.LoginScreenElement.ACCEPT_TERMS_CHECKBOX_TAG
import com.artishevsky.loginscreenkata.presentation.LoginScreenElement.ACCEPT_TERMS_TEXT_TAG
import com.artishevsky.loginscreenkata.presentation.LoginScreenElement.EMAIL_TEXT_FIELD_TAG
import com.artishevsky.loginscreenkata.presentation.LoginScreenElement.PASSWORD_TEXT_FIELD_TAG
import com.artishevsky.loginscreenkata.presentation.LoginScreenElement.REPEAT_PASSWORD_TEXT_FIELD_TAG
import com.artishevsky.loginscreenkata.presentation.LoginScreenElement.SUBMIT_BUTTON_TAG
import com.artishevsky.loginscreenkata.ui.theme.LoginScreenKataTheme

@Composable
fun LoginScreen() {
    var submitEnabled by remember { mutableStateOf(false) }
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    var repeatedPasswordText by remember { mutableStateOf("") }
    var termsCheckedState by remember { mutableStateOf(false) }
    var formSubmittedState by remember { mutableStateOf(false) }

    LoginScreenKataTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = emailText.ifEmpty { stringResource(R.string.login_email_input_text) },
                    onValueChange = { newText -> emailText = newText },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag(EMAIL_TEXT_FIELD_TAG),
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = passwordText.ifEmpty { stringResource(R.string.login_password_input_text) },
                    onValueChange = { newText -> passwordText = newText },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag(PASSWORD_TEXT_FIELD_TAG)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = repeatedPasswordText.ifEmpty { stringResource(R.string.login_repeat_password_input_text) },
                    onValueChange = { newText -> repeatedPasswordText = newText },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag(REPEAT_PASSWORD_TEXT_FIELD_TAG)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Checkbox(
                        checked = termsCheckedState,
                        onCheckedChange = {
                            termsCheckedState = it
                            submitEnabled = it
                        },
                        modifier = Modifier.testTag(ACCEPT_TERMS_CHECKBOX_TAG)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(R.string.login_accept_terms_text),
                        modifier = Modifier.testTag(ACCEPT_TERMS_TEXT_TAG)
                    )
                }
                Button(
                    onClick = { formSubmittedState = true },
                    modifier = Modifier.testTag(SUBMIT_BUTTON_TAG),
                    enabled = submitEnabled
                ) {
                    Text(text = stringResource(R.string.login_submit_button_text))
                }
                if (formSubmittedState) {
                    Text(text = stringResource(R.string.login_form_submitted_text))
                }
            }
        }
    }
}

internal object LoginScreenElement {
    const val EMAIL_TEXT_FIELD_TAG = "emailTextField"
    const val PASSWORD_TEXT_FIELD_TAG = "passwordTextField"
    const val REPEAT_PASSWORD_TEXT_FIELD_TAG = "repeatPasswordTextField"
    const val ACCEPT_TERMS_CHECKBOX_TAG = "acceptTermsCheckbox"
    const val ACCEPT_TERMS_TEXT_TAG = "acceptTermsText"
    const val SUBMIT_BUTTON_TAG = "submitButton"
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginScreen()
}