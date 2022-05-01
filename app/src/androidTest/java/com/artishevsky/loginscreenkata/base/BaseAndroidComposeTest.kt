package com.artishevsky.loginscreenkata.base

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.artishevsky.loginscreenkata.presentation.LoginActivity
import org.junit.After
import org.junit.Before
import org.junit.Rule

internal abstract class BaseAndroidComposeTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<LoginActivity>()

    val activity: LoginActivity
        get() = composeTestRule.activity

    @Before
    open fun setUp() {

    }

    @After
    open fun tearDown() {

    }
}