package com.artishevsky.loginscreenkata.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
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
            Greeting("Android")
            TextField(
                value = stringResource(R.string.login_email_input_text),
                onValueChange = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("emailTextField"),
            )
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LoginScreen()
}