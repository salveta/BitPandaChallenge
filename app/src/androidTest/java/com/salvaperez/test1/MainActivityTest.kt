package com.salvaperez.test1

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import com.salvaperez.test1.presentation.ui.main.MainActivity
import org.junit.Rule
import org.junit.Test

class MainActivityTest {

    @get:Rule
    val activityTestRule = ActivityTestRule(MainActivity::class.java, false, false)

    @Test
    fun click_position_recyclerview_open_detail() {
        activityTestRule.launchActivity(null)

        onView(withId(R.id.rvWallet)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                        2,
                        ViewActions.click()
                )
        )
    }

    @Test
    fun show_filter_button_and_click_work() {
        activityTestRule.launchActivity(null)
        onView(withId(R.id.btnFilterCurrencies)).check(matches(isDisplayed()));
       onView(withId(R.id.btnFilterCurrencies)).perform(ViewActions.click())
    }
}