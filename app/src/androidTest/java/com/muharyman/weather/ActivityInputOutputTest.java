package com.muharyman.weather;

import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.muharyman.weather.view.page.MainActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.action.ViewActions.swipeLeft;
import static androidx.test.espresso.action.ViewActions.swipeRight;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ActivityInputOutputTest {

    private String cityName = "Jakarta";

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Before
    public void init(){
        mActivityRule.getActivity().getFragmentManager().beginTransaction();
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.muharyman.weather", appContext.getPackageName());
    }

    @Test
    public void activityLaunch2() {
        onView(withId(R.id.gps)).perform(click());
        onView(withId(R.id.kota)).check(matches((isDisplayed())));
        onView(withId(R.id.viewPager)).perform(swipeRight());
        onView(withId(R.id.viewPager)).perform(swipeLeft());
    }

    @Test
    public void activityLaunch() {
        onView(withId(R.id.input_kota)).perform(typeText(cityName));
        closeSoftKeyboard();
        onView(withId(R.id.button_kota)).perform(click());
        onView(withId(R.id.kota)).check(matches(withText(cityName)));
        onView(withId(R.id.kota)).check(matches((isDisplayed())));
        onView(withId(R.id.viewPager)).perform(swipeRight());
        onView(withId(R.id.viewPager)).perform(swipeLeft());
    }

}
