package com.artishevsky.loginscreenkata.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
import com.artishevsky.loginscreenkata.ui.theme.LoginScreenKataTheme

@Composable
fun LoginScreen() {
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
                    value = stringResource(R.string.login_email_input_text),
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag(EMAIL_TEXT_FIELD_TAG),
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = stringResource(R.string.login_password_input_text),
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag(PASSWORD_TEXT_FIELD_TAG)
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = stringResource(R.string.login_repeat_password_input_text),
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag(REPEAT_PASSWORD_TEXT_FIELD_TAG)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Checkbox(
                        checked = false,
                        onCheckedChange = {},
                        modifier = Modifier.testTag(ACCEPT_TERMS_CHECKBOX_TAG)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(R.string.login_accept_terms_text),
                        modifier = Modifier.testTag(ACCEPT_TERMS_TEXT_TAG)
                    )
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