package com.koma.film.main

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isSelected
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.koma.film.R
import org.hamcrest.core.IsNot.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun should_select_HomeFragment_when_launched() {
        onView(withId(R.id.nav_home)).check(matches(isSelected()))
        onView(withId(R.id.nav_tv)).check(matches(not(isSelected())))
        onView(withId(R.id.nav_people)).check(matches(not(isSelected())))
    }

    @Test
    fun should_select_TVFragment_when_click_nav_tv() {
        onView(withId(R.id.nav_tv)).perform(click())
        onView(withId(R.id.nav_tv)).check(matches(isSelected()))
        onView(withId(R.id.nav_home)).check(matches(not(isSelected())))
        onView(withId(R.id.nav_people)).check(matches(not(isSelected())))
    }

    @Test
    fun should_display_PeopleFragment_when_click_nav_people() {
        onView(withId(R.id.nav_people)).perform(click())
        onView(withId(R.id.nav_people)).check(matches(isSelected()))
        onView(withId(R.id.nav_home)).check(matches(not(isSelected())))
        onView(withId(R.id.nav_tv)).check(matches(not(isSelected())))
    }
}