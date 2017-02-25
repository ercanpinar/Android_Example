package com.ercanpinar.news;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.ercanpinar.news.activity.MainActivity;
import com.ercanpinar.news.activity.SplashActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * SendNewPostTest , which will execute on an Android device.
 *
 * Android Device Version >= 5.0  (Since it has a DataBinding structure.)
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class SendNewPostTest {

    @Rule
    public ActivityTestRule<SplashActivity> mSplashActivityRule = new ActivityTestRule<>(
            SplashActivity.class);
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Before
    public void setUp() throws Exception {
        onView(withId(R.id.formEditTextTitle))
                .perform(typeText("Test Title"), closeSoftKeyboard());
        onView(withId(R.id.formEditTextBody))
                .perform(typeText("Test Body"), closeSoftKeyboard());
    }

    @Test
    public void sendNewPost() throws Exception {
        onView(withId(R.id.buttonSend)).perform(click());
    }
}
