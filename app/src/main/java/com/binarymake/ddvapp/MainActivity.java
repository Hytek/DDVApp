package com.binarymake.ddvapp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends BaseActivity {

    //private WeeklyAdapter weeklyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activateToolbar();

        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recList.setLayoutManager(llm);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        WeeklyAdapter wa = new WeeklyAdapter(createList(7));
        recList.setAdapter(wa);

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
        //}

        return super.onOptionsItemSelected(item);
    }

    private List<WeeklyInfo> createList(int size) {

        List<WeeklyInfo> result = new ArrayList<WeeklyInfo>();
        for (int i=1; i <= size; i++) {
            WeeklyInfo wi = new WeeklyInfo();
            wi.breakfast = WeeklyInfo.BREAKFAST_PREFIX + i;
            wi.dinner = WeeklyInfo.DINNER_PREFIX + i;
            wi.lunch = WeeklyInfo.LUNCH_PREFIX + i + "@test.com";
            wi.snacks = WeeklyInfo.SNACKS_PREFIX + i;
            wi.weekday = WeeklyInfo.WEEKDAY_PREFIX + i;
            result.add(wi);
        }

        return result;
    }

}