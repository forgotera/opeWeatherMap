package com.example.weather

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.weather.presentation.view.MainActivity
import org.junit.Rule
import org.junit.Test


class UITest {

    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testSendMessageUI() {
        onView(withId(R.id.temperature_text_view)).check(matches(withText("Тут будет погода")))
    }

    @Test
    fun writeTextTest(){
        onView(withId(R.id.getcity_edit_text_view))
            .check(matches(isDisplayed()))
            .perform(typeText("T"))

        onView(withId(R.id.temperature_text_view)).check(matches(withText("Город не найден")))
    }

    @Test
    fun minTempDisplayedTest(){
        onView(withId(R.id.getcity_edit_text_view))
            .check(matches(isDisplayed()))
            .perform(typeText("Tokio"))

        onView(withId(R.id.min_temp)).check(matches(isDisplayed()))
    }

    @Test
    fun maxTempDisplayedTest(){
        onView(withId(R.id.getcity_edit_text_view))
            .check(matches(isDisplayed()))
            .perform(typeText("Tokio"))

        onView(withId(R.id.max_temp)).check(matches(isDisplayed()))
    }

    @Test
    fun feelsLikeTempDisplayedTest(){
        onView(withId(R.id.getcity_edit_text_view))
            .check(matches(isDisplayed()))
            .perform(typeText("Tokio"))

        onView(withId(R.id.feels_like)).check(matches(isDisplayed()))
    }

}