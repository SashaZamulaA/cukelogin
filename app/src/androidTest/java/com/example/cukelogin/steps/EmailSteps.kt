package com.example.cukelogin.steps

import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.platform.app.InstrumentationRegistry
import com.example.cukelogin.LoginActivity
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class LoginSteps {

    private fun id(name: String): Int {
        val ctx = InstrumentationRegistry.getInstrumentation().targetContext
        return ctx.resources.getIdentifier(name, "id", ctx.packageName)
    }

    @Given("I open the app")
    fun iOpenTheApp() {
        // запускаємо LoginActivity
        launchActivity<LoginActivity>()
    }

    @When("I enter {string} into the field with id {string}")
    fun iEnterIntoField(value: String, idName: String) {
        onView(withId(id(idName))).perform(replaceText(value), closeSoftKeyboard())
    }

    @When("I tap the button with id {string}")
    fun iTapButton(idName: String) {
        onView(withId(id(idName))).perform(click())
    }

    @Then("I see the Home screen")
    fun iSeeHomeScreen() {
        onView(withId(id("homeWelcomeText"))).check(matches(isDisplayed()))
        onView(withText("Welcome!")).check(matches(isDisplayed()))
    }

    @Then("I see text {string}")
    fun iSeeText(text: String) {
        onView(withText(text)).check(matches(isDisplayed()))
    }
}
