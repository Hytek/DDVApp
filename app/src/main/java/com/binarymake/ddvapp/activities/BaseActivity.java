package com.binarymake.ddvapp.activities;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.binarymake.ddvapp.R;

/**
 * Created by Jakob on 09-08-2015.
 */
public class BaseActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    protected Toolbar activateToolbar(int i) {
        if(mToolbar == null && i == 1) {
            mToolbar = (Toolbar) findViewById(R.id.app_bar_main);
            if(mToolbar != null) {
                setSupportActionBar(mToolbar);
            }
            else
            if(mToolbar == null && i == 2) {
                mToolbar = (Toolbar) findViewById(R.id.app_bar_add);
                if (mToolbar != null) {
                    setSupportActionBar(mToolbar);
                }
            }
        }
        return mToolbar;
    }

//    protected Toolbar activateToolbarWithHomeEnabled() {
//        activateToolbar();
//        if(mToolbar != null) {
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        }
//        return mToolbar;
//
//    }

}