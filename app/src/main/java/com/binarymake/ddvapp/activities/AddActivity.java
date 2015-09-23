package com.binarymake.ddvapp.activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.binarymake.ddvapp.R;
import com.binarymake.ddvapp.slidingtabs.SlidingTabLayout;
import com.binarymake.ddvapp.slidingtabs.ViewPagerAdapter;
import com.binarymake.ddvapp.dao.MealDAO;
import com.binarymake.ddvapp.model.Meal;

/**
 * Created by Jakob on 26-08-2015.
 */

public class AddActivity extends BaseActivity {

    // Declaring Your View and Variables
    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingTabLayout tabs;
    CharSequence Titles[] = {"Morgenmad", "Frokost", "Aftensmad", "Mellemmåltid"};
    int Numboftabs = 4;
    private int dag;
    private int tidspunkt;
    private int maaltid;

    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        dag = getIntent().getIntExtra("dag", -1);
        tidspunkt = getIntent().getIntExtra("tidspunkt", -1);
        maaltid = getIntent().getIntExtra("maaltid", -1);
        Toast.makeText(this, "dag er "+dag+" tid er "+tidspunkt+" maaltidID i AddActivity er "+ maaltid, Toast.LENGTH_LONG).show();

//        activateToolbar(2);

        // Creating The Toolbar and setting it as the Toolbar for the activity

//        toolbar = (Toolbar) findViewById(R.id.tool_bar);
//        setSupportActionBar(toolbar);


        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), Titles, Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);

        pager.setCurrentItem(tidspunkt);

        // Assiging the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}