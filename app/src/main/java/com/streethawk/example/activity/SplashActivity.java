package com.streethawk.example.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.streethawk.example.R;

/**
 * Created by ercanpinar on 03/02/2017.
 **/

/**
 * ***** Application Splash Screen *****
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /****** Actionbar Hide *****/
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.hide();

        /****** Spash Fullscreen *****/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

        /****** MainActivity Open *****/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 1 * 2000);

    }
}
