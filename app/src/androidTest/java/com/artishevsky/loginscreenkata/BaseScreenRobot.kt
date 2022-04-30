package com.artishevsky.loginscreenkata

import androidx.annotation.StringRes
import androidx.compose.ui.test.junit4.AndroidComposeTestRule
import androidx.test.ext.junit.rules.ActivityScenarioRule

internal abstract class BaseScreenRobot constructor(
    protected val composeTestRule: AndroidComposeTestRule<ActivityScenarioRule<MainActivity>, MainActivity>
) {
    protected fun getString(@StringRes resId: Int) = composeTestRule.activity.getString(resId)
}