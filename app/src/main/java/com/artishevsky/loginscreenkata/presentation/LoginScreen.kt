package com.artishevsky.loginscreenkata.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artishevsky.loginscreenkata.R
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
                        .testTag("emailTextField"),
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = stringResource(R.string.login_password_input_text),
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("passwordTextField")
                )
                Spacer(modifier = Modifier.height(16.dp))
                TextField(
                    value = stringResource(R.string.login_repeated_password_text),
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("repeatedPasswordTextField")
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginScreen()
}