package com.binarymake.ddvapp.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.binarymake.ddvapp.model.Meal;
import com.binarymake.ddvapp.model.MealWater;

import java.util.ArrayList;
import java.util.List;

public class MealWaterDAO {

    public static final String TAG = "MealWaterDAO";

    private Context mContext;

    // Database fields
    private SQLiteDatabase mDatabase;
    private DatabaseHelper mDbHelper;
    private String[] mAllColumns = {DatabaseHelper.COLUMN_CATEGORY_WATER_ID,
            DatabaseHelper.COLUMN_CATEGORY_WATER_FOOD_ID, DatabaseHelper.COLUMN_WATER_DESCRIPTION};

    public MealWaterDAO(Context context) {
        mDbHelper = new DatabaseHelper(context);
        this.mContext = context;
        // open the database
        try {
            open();
        } catch (SQLException e) {
            Log.e(TAG, "SQLException on opening database " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void open() throws SQLException {
        mDatabase = mDbHelper.getWritableDatabase();
    }

    public void close() {
        mDbHelper.close();
    }

    public MealWater createMealWater(String mFoodId, long mealId) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_CATEGORY_WATER_FOOD_ID, mFoodId);
//		values.put(DatabaseHelper.COLUMN_EMPLOYE_LAST_NAME, lastName);
//		values.put(DatabaseHelper.COLUMN_EMPLOYE_ADDRESS, address);
//		values.put(DatabaseHelper.COLUMN_EMPLOYE_EMAIL, email);
//		values.put(DatabaseHelper.COLUMN_EMPLOYE_PHONE_NUMBER, phoneNumber);
//		values.put(DatabaseHelper.COLUMN_EMPLOYE_SALARY, salary);
//        values.put(DatabaseHelper.COLUMN_MEALWATER_MEAL_ID, mealId);
        long insertId = mDatabase.insert(DatabaseHelper.TABLE_CATEGORY_WATER, null, values);
        Cursor cursor = mDatabase.query(DatabaseHelper.TABLE_CATEGORY_WATER,
                mAllColumns, DatabaseHelper.COLUMN_CATEGORY_WATER_ID + " = " + insertId, null, null, null, null);
        cursor.moveToFirst();
        MealWater newMealWater = cursorToMealWater(cursor);
        cursor.close();
        return newMealWater;
    }

    public void deleteMealWater(MealWater mealWater) {
        long id = mealWater.getId();
        System.out.println("the deleted mealWater has the id: " + id);
        mDatabase.delete(DatabaseHelper.TABLE_CATEGORY_WATER, DatabaseHelper.COLUMN_CATEGORY_WATER_ID + " = " + id, null);
    }

    public List<Meal> getAllMeals() {
        List<Meal> listMealWater = new ArrayList<>();

        Cursor query = mDatabase.rawQuery("SELECT * from meal_water", null);
        if(query.moveToFirst()) {
            do {

                // Cycle through all records
                Meal meal = cursorToMealWater(query);
                listMealWater.add(meal);
            } while(query.moveToNext());
        }

        return listMealWater;
    }

    public List<MealWater> getAllWater() {
        List<MealWater> listMealWater = new ArrayList<>();

        Cursor query = mDatabase.rawQuery("SELECT * from meal_water", null);
        if(query.moveToFirst()) {
            do {

                // Cycle through all records
                MealWater mealWater = cursorToMealWater(query);
                listMealWater.add(mealWater);
            } while(query.moveToNext());
        }

        return listMealWater;
    }

    private MealWater cursorToMealWater(Cursor cursor) {
        MealWater mealWater = new MealWater();
        mealWater.setDescription(cursor.getString(0));

            return mealWater;
        }
}