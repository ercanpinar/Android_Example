package com.ercanpinar.news.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.ercanpinar.news.R;
import com.ercanpinar.news.fragment.NewPostFragment;
import com.ercanpinar.news.util.Constant;
import com.ercanpinar.news.util.Util;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateManager;

/**
 * Created by ercanpinar on 03/02/2017.
 */

/**
 * ***** Application Main Activity Class *****
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /****** Actionbar Hide *****/
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.hide();

        /****** NewPostFragment Open *****/
        replaceFragment(new NewPostFragment());

    }


    /**
     * ***** Replace Fragment Metod *******
     */
    public void replaceFragment(Fragment fragment) {

        /****** Keyboard Close *****/
        Util.closeKeyboard(this);

        /****** ReplaceFragment *****/
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.bottom_enter, R.anim.top_exit);
        transaction.add(R.id.fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }


    @Override
    protected void onResume() {
        super.onResume();

        /****** Hockeyapp CrashTracker Start *****/
        checkForCrashes();

        /****** Hockeyapp Updates Start *****/
        checkForUpdates();
    }

    /**
     * ******** HockeyApp  Crash Analytic ********
     */
    private void checkForCrashes() {
        CrashManager.register(this, Constant.hockeyAppAlphaId);
    }

    /**
     * ******** HockeyApp  Distrubition ********
     */
    private void checkForUpdates() {
        UpdateManager.register(this, Constant.hockeyAppAlphaId);
    }

    /**
     * ****** OnBack Metod ******
     */
    @Override
    public void onBackPressed() {

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment);

        if (fragment instanceof NewPostFragment)
            finish();
        else
            replaceFragment(new NewPostFragment());
    }
}
