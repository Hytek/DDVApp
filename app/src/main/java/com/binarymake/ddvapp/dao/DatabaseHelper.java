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

    private static final String DATABASE_NAME = "meals.db";
    private static final int DATABASE_VERSION = 1;

    // SQL statement of the meals table creation
    private static final String SQL_CREATE_TABLE_MEALS = "CREATE TABLE " + TABLE_MEALS + "("
            + COLUMN_MEAL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_MEAL_TYPE + " TEXT NOT NULL, "
            + COLUMN_MEAL_DESCRIPTION + " TEXT NOT NULL "
            + ");";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(SQL_CREATE_TABLE_MEALS);
        database.execSQL("INSERT OR IGNORE INTO meal VALUES('1', 1, 'Morgenmad:  \n');");
        database.execSQL("INSERT OR IGNORE INTO meal VALUES('2', 2, 'Frokost:    \n');");
        database.execSQL("INSERT OR IGNORE INTO meal VALUES('3', 3, 'Aftensmad:  \n');");
        database.execSQL("INSERT OR IGNORE INTO meal VALUES('4', 4, 'Mellemmåltid:');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG,
                "Upgrading the database from version " + oldVersion + " to " + newVersion);
        // clear all data
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEALS);

        // recreate the tables
        onCreate(db);
    }

//    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
//    }
}