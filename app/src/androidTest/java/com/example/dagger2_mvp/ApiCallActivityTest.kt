package com.example.dagger2_mvp


import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.SmallTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4

import com.example.dagger2_mvp.views.api_call.ApiCallActivity

import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SmallTest
class ApiCallActivityTest {
    @Rule
    var mApiCallActivityTestRule = ActivityTestRule(ApiCallActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun checkRecyclerView() {
        Espresso.registerIdlingResources(mApiCallActivityTestRule.activity.countingIdlingResource)
        Espresso.onView(ViewMatchers.withId(R.id.btn_api_call)).perform(ViewActions.click())
    }
}
