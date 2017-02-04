package com.streethawk.example.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import com.streethawk.example.R;
import com.streethawk.example.fragment.NewPostFragment;
import com.streethawk.example.util.Util;

import net.hockeyapp.android.CrashManager;
import net.hockeyapp.android.UpdateManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = this.getSupportActionBar();
        actionBar.hide();

        replaceFragment(new NewPostFragment());

    }

    public void replaceFragment(Fragment fragment) {

        Util.closeKeyboard(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.bottom_enter,R.anim.top_exit);
        transaction.add(R.id.fragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    protected void onResume() {
        super.onResume();
        checkForCrashes();
        checkForUpdates();
    }

    /**
     * HockeyApp  Analytic - Distrubition
     * */
    private void checkForCrashes() {
        //alpha
        CrashManager.register(this, "e1b1aa793e7241488c2d586d8e4778f0");
    }
    private void checkForUpdates() {
        //alpha
        UpdateManager.register(this, "e1b1aa793e7241488c2d586d8e4778f0");
    }


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
