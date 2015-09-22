package com.binarymake.ddvapp.dao;

/**
 * Created by Jakob on 02-09-2015.
 */

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

public class MealDAO {

    public static final String TAG = "MealDAO";

    // Database fields
    private SQLiteDatabase mDatabase;
    private DatabaseHelper mDbHelper;
    private Context mContext;
    private String[] mAllColumns = { DatabaseHelper.COLUMN_MEAL_ID,
            DatabaseHelper.COLUMN_MEAL_TYPE, DatabaseHelper.COLUMN_MEAL_DESCRIPTION};

    public MealDAO(Context context) {
        this.mContext = context;
        mDbHelper = new DatabaseHelper(context);
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

    public Meal createMeal(int type, String description) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_MEAL_TYPE, type);
        values.put(DatabaseHelper.COLUMN_MEAL_DESCRIPTION, description);
        long insertId = mDatabase.insert(DatabaseHelper.TABLE_MEALS, null, values);
        Cursor cursor = mDatabase.query(DatabaseHelper.TABLE_MEALS, mAllColumns,
                DatabaseHelper.COLUMN_MEAL_ID + " = " + insertId, null, null,
                null, null);
        cursor.moveToFirst();
        Meal newMeal = cursorToMeal(cursor);
        cursor.close();
        return newMeal;
    }

    public void deleteMeal(Meal meal) {
        long id = meal.getId();
        // delete all mealWaters of this meal
        MealWaterDAO mealWaterDao = new MealWaterDAO(mContext);
        List<MealWater> listMealWater = mealWaterDao.getAllWater();
        if (listMealWater != null && !listMealWater.isEmpty()) {
            for (MealWater e : listMealWater) {
                mealWaterDao.deleteMealWater(e);
            }
        }

        System.out.println("the deleted meal has the id: " + id);
        mDatabase.delete(DatabaseHelper.TABLE_MEALS, DatabaseHelper.COLUMN_MEAL_ID
                + " = " + id, null);
    }

    public List<Meal> getAllMeals() {
        List<Meal> listMeals = new ArrayList<>();

        Cursor query = mDatabase.rawQuery("SELECT * from meal", null);
        if(query.moveToFirst()) {
            do {

                // Cycle through all records
                Meal meal = cursorToMeal(query);
                listMeals.add(meal);
            } while(query.moveToNext());
        }

//        Cursor cursor = mDatabase.query(DatabaseHelper.TABLE_MEALS, mAllColumns,
//                null, null, null, null, null);
//        if (cursor != null) {
//            cursor.moveToFirst();
//            while (!cursor.isAfterLast()) {
//                Meal meal = cursorToMeal(cursor);
//                listMeals.add(meal);
//                cursor.moveToNext();
//            }

            // make sure to close the cursor
//            cursor.close();
//        }
        return listMeals;
    }

    public List<Meal> getBrMeals() {
        List<Meal> listBrMeals = new ArrayList<Meal>();

        Cursor query = mDatabase.rawQuery("SELECT * from meal WHERE meal_type = 1", null);
        if(query.moveToFirst()) {
            do {

                // Cycle through all records
                Meal meal = cursorToMeal(query);
                listBrMeals.add(meal);
            } while(query.moveToNext());
        }
        return listBrMeals;
    }

    public List<Meal> getLuMeals() {
        List<Meal> listLuMeals = new ArrayList<Meal>();

        Cursor query = mDatabase.rawQuery("SELECT * from meal WHERE meal_type = 2", null);
        if(query.moveToFirst()) {
            do {

                // Cycle through all records
                Meal meal = cursorToMeal(query);
                listLuMeals.add(meal);
            } while(query.moveToNext());
        }
        return listLuMeals;
    }

    public List<Meal> getDiMeals() {
        List<Meal> listDiMeals = new ArrayList<Meal>();

        Cursor query = mDatabase.rawQuery("SELECT * from meal WHERE meal_type = 3", null);
        if(query.moveToFirst()) {
            do {

                // Cycle through all records
                Meal meal = cursorToMeal(query);
                listDiMeals.add(meal);
            } while(query.moveToNext());
        }
        return listDiMeals;
    }

    public List<Meal> getSnMeals() {
        List<Meal> listSnMeals = new ArrayList<Meal>();

        Cursor query = mDatabase.rawQuery("SELECT * from meal WHERE meal_type = 4", null);
        if(query.moveToFirst()) {
            do {

                // Cycle through all records
                Meal meal = cursorToMeal(query);
                listSnMeals.add(meal);
            } while(query.moveToNext());
        }
        return listSnMeals;
    }

    public Meal getMealById(long id) {
        Cursor cursor = mDatabase.query(DatabaseHelper.TABLE_MEALS, mAllColumns,
                DatabaseHelper.COLUMN_MEAL_ID + " = ?",
                new String[] { String.valueOf(id) }, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        Meal meal = cursorToMeal(cursor);
        return meal;
    }

    protected Meal cursorToMeal(Cursor cursor) {
        Meal meal = new Meal();
        meal.setId(cursor.getInt(0));
        meal.setType(cursor.getInt(1));
        meal.setDescription(cursor.getString(2));
//        meal.setWebsite(cursor.getString(3));
//        meal.setPhoneNumber(cursor.getString(4));
        return meal;
    }

}