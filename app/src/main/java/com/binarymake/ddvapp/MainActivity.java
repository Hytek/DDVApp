package com.binarymake.ddvapp;

/**
 * Created by Jakob on 03-09-2015.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import android.widget.AdapterView.OnItemClickListener;

import com.binarymake.ddvapp.activities.AddActivity;
import com.binarymake.ddvapp.activities.BaseActivity;
import com.binarymake.ddvapp.adapter.ListMealsAdapter;
import com.binarymake.ddvapp.dao.MealDAO;
import com.binarymake.ddvapp.model.Meal;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    public static final String TAG = "MainActivity";

//    public static final int REQUEST_CODE_ADD_COMPANY = 40;

    private ListView mListviewMeals;

    private MealDAO mMealDao;
    private List<Meal> mBrListMeals;
    private List<Meal> mLuListMeals;
    private List<Meal> mDiListMeals;
    private List<Meal> mSnListMeals;
    private ListMealsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activateToolbar(1);

        // initialize views
        initViews();

        // fill the dailyListView
        mMealDao = new MealDAO(this);
        mBrListMeals = mMealDao.getBrMeals();
        mLuListMeals = mMealDao.getLuMeals();
        mDiListMeals = mMealDao.getDiMeals();
        mSnListMeals = mMealDao.getSnMeals();
        mAdapter = new ListMealsAdapter(this, mBrListMeals, mLuListMeals, mDiListMeals, mSnListMeals, MainActivity.this);
        mListviewMeals.setAdapter(mAdapter);

        // fill the WeeklyListView
        RecyclerView mRecyclerViewWeekly = (RecyclerView) findViewById(R.id.overview_list);
        mRecyclerViewWeekly.setHasFixedSize(true);
        LinearLayoutManager llm2 = new LinearLayoutManager(this);
        mRecyclerViewWeekly.setLayoutManager(llm2);
        llm2.setOrientation(LinearLayoutManager.VERTICAL);

        WeeklyAdapter oa = new WeeklyAdapter(createOverviewList());
        mRecyclerViewWeekly.setAdapter(oa);

    }

    private void initViews() {
        this.mListviewMeals = (ListView) findViewById(R.id.view_daily_list);
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

//    private List<MealInfo> createWeeklyList(int size) {

//        List<MealInfo> result = new ArrayList<MealInfo>();
//        for (int i = 1; i <= size; i++) {
//            MealInfo wi = new MealInfo();
//            wi.breakfast = MealInfo.BREAKFAST_PREFIX;
//            wi.dinner = MealInfo.DINNER_PREFIX;
//            wi.lunch = MealInfo.LUNCH_PREFIX;
//            wi.snacks = MealInfo.SNACKS_PREFIX;
//            wi.weekday = MealInfo.WEEKDAY_PREFIX + i;
//            result.add(wi);
//        }

//          return result;
//    }

    private List<WeeklyInfo> createOverviewList() {

        List<WeeklyInfo> result = new ArrayList<WeeklyInfo>();
        //for (int i=1; i <= size; i++) {
        WeeklyInfo oi = new WeeklyInfo();
        oi.meat1 = WeeklyInfo.MEAT1_PREFIX + "0/3(5)";
        oi.fish1 = WeeklyInfo.FISH1_PREFIX + "0/3(5)";
        oi.eggs = WeeklyInfo.EGGS_PREFIX + "0/4(6)";
        oi.meat2 = WeeklyInfo.MEAT2_PREFIX + "0/(5)";
        oi.meat3 = WeeklyInfo.MEAT3_PREFIX + "0/(1)";
        oi.fish2 = WeeklyInfo.FISH2_PREFIX + "0/(1)";
        oi.cheese1 = WeeklyInfo.CHEESE1_PREFIX + "0/(6)";
        oi.cheese2 = WeeklyInfo.CHEESE2_PREFIX + "0/(4)";
        oi.cereal = WeeklyInfo.CEREAL_PREFIX + "0/(5)";

        result.add(oi);
        //}

        return result;
    }

//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        Meal clickedMeal = mAdapter.getBrItem(position);
//        Log.d(TAG, "clickedItem : " + clickedMeal.getType());
//        Intent intent = new Intent(this, AddActivity.class);
        //intent.putExtra(AddActivity.EXTRA_SELECTED_COMPANY_ID, Meal.getId());
//        startActivity(intent);
//    }
}