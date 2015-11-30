package com.example.nuriskandarz.praktikum_11;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Nur Iskandar Z on 30/11/2015.
 */

public class DBHelper  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 4;

    private static final String DATABASE_NAME = "crud.db";

    public DBHelper(Context context ) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_BIODATA = "CREATE TABLE " + Biodata.TABLE  + "("
                + Biodata.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                + Biodata.KEY_nama + " TEXT, "
                + Biodata.KEY_alamat + " TEXT )";

        db.execSQL(CREATE_TABLE_BIODATA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Biodata.TABLE);

        onCreate(db);

    }

}
