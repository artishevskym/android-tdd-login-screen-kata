package com.artishevsky.loginscreenkata.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artishevsky.loginscreenkata.R
import com.artishevsky.loginscreenkata.presentation.LoginScreenTag.TAG_ACCEPT_TERMS_CHECKBOX
import com.artishevsky.loginscreenkata.presentation.LoginScreenTag.TAG_ACCEPT_TERMS_TEXT
import com.artishevsky.loginscreenkata.presentation.LoginScreenTag.TAG_EMAIL_TEXT_FIELD
import com.artishevsky.loginscreenkata.presentation.LoginScreenTag.TAG_PASSWORD_TEXT_FIELD
import com.artishevsky.loginscreenkata.presentation.LoginScreenTag.TAG_PASSWORD_VISIBILITY_ICON
import com.artishevsky.loginscreenkata.presentation.LoginScreenTag.TAG_REPEAT_PASSWORD_TEXT_FIELD
import com.artishevsky.loginscreenkata.presentation.LoginScreenTag.TAG_REPEAT_PASSWORD_VISIBILITY_ICON
import com.artishevsky.loginscreenkata.presentation.LoginScreenTag.TAG_SUBMIT_BUTTON
import com.artishevsky.loginscreenkata.ui.theme.LoginScreenKataTheme
import kotlinx.coroutines.flow.collect

@Composable
fun LoginScreen() {
    LoginScreenKataTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            var validationSuccessful by remember { mutableStateOf(false) }
            val viewModel = viewModel<LoginViewModel>()
            val state = viewModel.state
            val context = LocalContext.current

            LaunchedEffect(key1 = context) {
                viewModel.validationEvents.collect { event ->
                    validationSuccessful = when (event) {
                        is LoginViewModel.ValidationEvent.Success -> true
                        is LoginViewModel.ValidationEvent.Failure -> false
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(32.dp),
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = state.email,
                    onValueChange = { viewModel.onEvent(LoginScreenEvent.EmailChanged(it)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag(TAG_EMAIL_TEXT_FIELD),
                    isError = state.emailError != null,
                    placeholder = {
                        Text(text = stringResource(R.string.login_email_input_text))
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Email
                    )
                )
                if (state.emailError != null) {
                    Text(
                        text = state.emailError,
                        color = MaterialTheme.colors.error,
                        modifier = Modifier.align(Alignment.End)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                var showPassword by remember { mutableStateOf(false) }
                TextField(
                    value = state.password,
                    onValueChange = { viewModel.onEvent(LoginScreenEvent.PasswordChanged(it)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag(TAG_PASSWORD_TEXT_FIELD),
                    isError = state.passwordError != null,
                    placeholder = {
                        Text(text = stringResource(R.string.login_password_input_text))
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val icon =
                            if (showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        val description = if (showPassword) "Hide password" else "Show password"
                        IconButton(
                            modifier = Modifier.testTag(TAG_PASSWORD_VISIBILITY_ICON),
                            onClick = { showPassword = !showPassword }
                        ) {
                            Icon(
                                imageVector = icon,
                                contentDescription = description
                            )
                        }
                    }
                )
                if (state.passwordError != null) {
                    Text(
                        text = state.passwordError,
                        color = MaterialTheme.colors.error,
                        modifier = Modifier.align(Alignment.End)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                var showRepeatPassword by remember { mutableStateOf(false) }
                TextField(
                    value = state.repeatedPassword,
                    onValueChange = { viewModel.onEvent(LoginScreenEvent.RepeatedPasswordChanged(it)) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag(TAG_REPEAT_PASSWORD_TEXT_FIELD),
                    isError = state.repeatedPasswordError != null,
                    placeholder = {
                        Text(text = stringResource(R.string.login_repeat_password_input_text))
                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password
                    ),
                    visualTransformation = if (showRepeatPassword) VisualTransformation.None else PasswordVisualTransformation(),
                    trailingIcon = {
                        val icon =
                            if (showRepeatPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                        val description =
                            if (showRepeatPassword) "Hide repeat password" else "Show repeat password"
                        IconButton(
                            modifier = Modifier.testTag(TAG_REPEAT_PASSWORD_VISIBILITY_ICON),
                            onClick = { showRepeatPassword = !showRepeatPassword }
                        ) {
                            Icon(
                                imageVector = icon,
                                contentDescription = description
                            )
                        }
                    }
                )
                if (state.repeatedPasswordError != null) {
                    Text(
                        text = state.repeatedPasswordError,
                        color = MaterialTheme.colors.error,
                        modifier = Modifier.align(Alignment.End)
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Checkbox(
                        checked = state.acceptedTerms,
                        onCheckedChange = {
                            viewModel.onEvent(LoginScreenEvent.AcceptTerms(it))
                        },
                        modifier = Modifier.testTag(TAG_ACCEPT_TERMS_CHECKBOX)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = stringResource(R.string.login_accept_terms_text),
                        modifier = Modifier
                            .testTag(TAG_ACCEPT_TERMS_TEXT)
                            .align(Alignment.CenterVertically)
                    )
                }
                if (state.acceptedTermsError != null) {
                    Text(
                        text = state.acceptedTermsError,
                        color = MaterialTheme.colors.error,
                        modifier = Modifier.align(Alignment.End)
                    )
                }
                Button(
                    onClick = { viewModel.onEvent(LoginScreenEvent.Submit) },
                    modifier = Modifier
                        .testTag(TAG_SUBMIT_BUTTON)
                        .align(Alignment.End),
                ) {
                    Text(text = stringResource(R.string.login_submit_button_text))
                }
                if (validationSuccessful) {
                    Text(text = stringResource(R.string.login_result_success_text))
                }
            }
        }
    }
}

internal object LoginScreenTag {
    const val TAG_EMAIL_TEXT_FIELD = "emailTextField"
    const val TAG_PASSWORD_TEXT_FIELD = "passwordTextField"
    const val TAG_REPEAT_PASSWORD_TEXT_FIELD = "repeatPasswordTextField"
    const val TAG_ACCEPT_TERMS_CHECKBOX = "acceptTermsCheckbox"
    const val TAG_ACCEPT_TERMS_TEXT = "acceptTermsText"
    const val TAG_SUBMIT_BUTTON = "submitButton"
    const val TAG_REPEAT_PASSWORD_VISIBILITY_ICON = "repeatPasswordVisibilityIcon"
    const val TAG_PASSWORD_VISIBILITY_ICON = "passwordVisibilityIcon"
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginScreen()
}