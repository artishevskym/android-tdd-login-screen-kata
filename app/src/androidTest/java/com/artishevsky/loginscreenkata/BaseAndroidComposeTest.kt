package com.artishevsky.loginscreenkata

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.After
import org.junit.Before
import org.junit.Rule

internal abstract class BaseAndroidComposeTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    val activity: MainActivity
        get() = composeTestRule.activity

    @Before
    open fun setUp() {

    }

    @After
    open fun tearDown() {

    }
}