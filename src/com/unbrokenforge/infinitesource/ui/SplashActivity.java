package com.unbrokenforge.infinitesource.ui;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

import com.unbrokenforge.infinitesource.R;

public class SplashActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_splash, menu);
        return true;
    }
}
