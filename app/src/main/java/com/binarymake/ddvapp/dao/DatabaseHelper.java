package com.binarymake.ddvapp.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Jakob on 02-09-2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TAG = "DBHelper";

    // columns of the meals table
    public static final String TABLE_MEALS = "meal";
    public static final String COLUMN_MEAL_ID = "_id";
    public static final String COLUMN_MEAL_TYPE = "meal_type";
    public static final String COLUMN_MEAL_DESCRIPTION = "description";
//    public static final String COLUMN_COMPANY_WEBSITE = "website";
//    public static final String COLUMN_COMPANY_PHONE_NUMBER = "phone_number";

    // columns of the water table
    public static final String TABLE_CATEGORY_WATER = "meal_water";
    public static final String COLUMN_CATEGORY_WATER_ID = COLUMN_MEAL_ID;
    public static final String COLUMN_CATEGORY_WATER_FOOD_ID = "food_id";
//    public static final String COLUMN_EMPLOYE_LAST_NAME = "last_name";
    public static final String COLUMN_WATER_DESCRIPTION = "description";
//    public static final String COLUMN_EMPLOYE_EMAIL = "email";
//    public static final String COLUMN_EMPLOYE_PHONE_NUMBER = COLUMN_COMPANY_PHONE_NUMBER;
//    public static final String COLUMN_EMPLOYE_SALARY = "salary";
//    public static final String COLUMN_MEALWATER_MEAL_ID = "meal_id";

    private static final String DATABASE_NAME = "meals.db";
    private static final int DATABASE_VERSION = 1;

    // SQL statement of the meals table creation
    private static final String SQL_CREATE_TABLE_MEALS = "CREATE TABLE " + TABLE_MEALS + "("
            + COLUMN_MEAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_MEAL_TYPE + " TEXT NOT NULL, "
            + COLUMN_MEAL_DESCRIPTION + " TEXT NOT NULL"
//            + COLUMN_COMPANY_WEBSITE + " TEXT NOT NULL, "
//            + COLUMN_COMPANY_PHONE_NUMBER + " TEXT NOT NULL "
            +");";

    // SQL statement of the water table creation
    private static final String SQL_CREATE_TABLE_CATEGORY_WATER = "CREATE TABLE " + TABLE_CATEGORY_WATER + "("
            + COLUMN_CATEGORY_WATER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CATEGORY_WATER_FOOD_ID + " TEXT NOT NULL, "
//            + COLUMN_EMPLOYE_LAST_NAME + " TEXT NOT NULL, "
            + COLUMN_WATER_DESCRIPTION + " TEXT NOT NULL"
//            + COLUMN_EMPLOYE_EMAIL + " TEXT NOT NULL, "
//            + COLUMN_EMPLOYE_PHONE_NUMBER + " TEXT NOT NULL, "
//            + COLUMN_EMPLOYE_SALARY + " REAL NOT NULL, "
//            + COLUMN_EMPLOYE_COMPANY_ID + " INTEGER NOT NULL "
            +");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(SQL_CREATE_TABLE_MEALS);
        database.execSQL(SQL_CREATE_TABLE_CATEGORY_WATER);
//        database.execSQL("INSERT OR IGNORE INTO meal_water VALUES('1', 1, 'Frokost');");
        database.execSQL("INSERT OR IGNORE INTO meal VALUES('1', 1, 'Morgenmad:');");
        database.execSQL("INSERT OR IGNORE INTO meal VALUES('2', 2, 'Frokost:');");
        database.execSQL("INSERT OR IGNORE INTO meal VALUES('3', 3, 'Aftensmad:');");
        database.execSQL("INSERT OR IGNORE INTO meal VALUES('4', 4, 'Mellemmåltid:');");
//        database.execSQL("INSERT OR IGNORE INTO meal VALUES('2', 1, 'Yoghurt med 2 bananer');");
//        database.execSQL("INSERT OR IGNORE INTO meal VALUES('3', 1, 'Yoghurt med 3 æbler');");
//        database.execSQL("INSERT OR IGNORE INTO meal VALUES('4', 2, 'Sandwich med laks');");
//        database.execSQL("INSERT OR IGNORE INTO meal VALUES('5', 2, 'Rester fra i går');");
//        database.execSQL("INSERT OR IGNORE INTO meal VALUES('6', 2, 'Avocadosalat med salsa');");
//        database.execSQL("INSERT OR IGNORE INTO meal VALUES('7', 1, 'Yoghurt med 4 æble');");
//        database.execSQL("INSERT OR IGNORE INTO meal VALUES('8', 1, 'Yoghurt med 5 bananer');");
//        database.execSQL("INSERT OR IGNORE INTO meal VALUES('9', 1, 'Yoghurt med 6 æbler');");
//        database.execSQL("INSERT OR IGNORE INTO meal VALUES('10', 1, 'Yoghurt med 7 æbler');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG,
                "Upgrading the database from version " + oldVersion + " to " + newVersion);
        // clear all data
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY_WATER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEALS);

        // recreate the tables
        onCreate(db);
    }

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }
}