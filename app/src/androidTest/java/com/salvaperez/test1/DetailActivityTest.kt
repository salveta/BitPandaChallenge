package com.salvaperez.test1

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import com.salvaperez.test1.presentation.ui.detail.DetailActivity
import com.salvaperez.test1.utils.currency
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class DetailActivityTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule<DetailActivity>(DetailActivity::class.java, true, false)

    @Before
    @Throws(Exception::class)
    fun setUp() {
        val intent = Intent()
        intent.putExtra(DetailActivity.CURRENCY_DATA, currency)
        activityRule.launchActivity(intent)
    }

    @Test
    fun check_name_coin_is_show() {
        Espresso.onView(withId(R.id.txtCurrencySymbol))
                .check(ViewAssertions.matches(withText("XRP")))
    }

    @Test
    fun check_price_coin_is_show() {
        Espresso.onView(withId(R.id.txtCurrencyPrice))
                .check(ViewAssertions.matches(withText("0.2119 €")))
    }
}