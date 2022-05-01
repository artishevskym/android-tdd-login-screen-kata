package com.artishevsky.loginscreenkata.base

import androidx.annotation.StringRes
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.artishevsky.loginscreenkata.presentation.LoginActivity

internal abstract class BaseScreenRobot constructor(
    protected val composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<LoginActivity>, LoginActivity>
) {
    protected fun getString(@StringRes resId: Int) = composeTestRule.activity.getString(resId)
}