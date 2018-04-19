package br.com.hussan.githubapi

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import br.com.hussan.githubapi.ui.repositories.RepositoriesActivity
import org.hamcrest.Matchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class RepositoriesActivityTests {

    @Rule @JvmField
    val mActivityRule: ActivityTestRule<RepositoriesActivity> = ActivityTestRule(RepositoriesActivity::class.java)

    @Test
    fun listGoesOverTheFold() {
        onView(withId(R.id.list_repos)).check(matches(isDisplayed()))
        onView(withId(R.id.progress)).check(matches(not(isDisplayed())))
    }
}
