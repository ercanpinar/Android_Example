package com.streethawk.example;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.streethawk.example.activity.MainActivity;
import com.streethawk.example.activity.SplashActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * ShowPostListTest , which will execute on an Android device.
 *
 * Android Device Version >= 5.0  (Since it has a DataBinding structure.)
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class ShowPostListTest {

    @Rule
    public ActivityTestRule<SplashActivity> mSplashActivityRule = new ActivityTestRule<>(
            SplashActivity.class);
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void sendNewPost() throws Exception {
        onView(withId(R.id.buttonShowAllRecord)).perform(click());
    }
}
