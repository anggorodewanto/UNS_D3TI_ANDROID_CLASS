package com.example.user.kelompok9_tugas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by USER on 03/12/2015.
 */
public class dbController extends SQLiteOpenHelper {
    private static final String LOGCAT = null;

    public dbController(Context applicationcontext) {
        super(applicationcontext, "kampus.db", null, 1);
        Log.d(LOGCAT, "Created");
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String query;
        query = "CREATE TABLE kampus ( kampusId INTEGER PRIMARY KEY, kampusName TEXT,alamat TEXT)";
        database.execSQL(query);
        Log.d(LOGCAT,"kampus Created");
    }
    @Override
    public void onUpgrade(SQLiteDatabase database, int version_old, int current_version) {
        String query;
        query = "DROP TABLE IF EXISTS kampus";
        database.execSQL(query);
        onCreate(database);
    }

    public void addKampus(HashMap<String, String> queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("kampusName", queryValues.get("kampusName"));
        values.put("alamat", queryValues.get("alamat"));
        database.insert("kampus", null, values);
        database.close();
    }

    public int updateKampus(HashMap<String, String> queryValues) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("kampusName", queryValues.get("kampusName"));
        values.put("alamat", queryValues.get("alamat"));
        return database.update("kampus", values, "kampusId" + " = ?", new String[] { queryValues.get("kampusId") });
    }

    public void deleteKampus(String id) {
        Log.d(LOGCAT,"delete");
        SQLiteDatabase database = this.getWritableDatabase();
        String deleteQuery = "DELETE FROM  kampus where kampusId='"+ id +"'";
        Log.d("query",deleteQuery);
        database.execSQL(deleteQuery);
    }

    public ArrayList<HashMap<String, String>> getAllkampus() {
        ArrayList<HashMap<String, String>> kampusList;
        kampusList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT  * FROM kampus";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<String, String>();
                map.put("kampusId", cursor.getString(0));
                map.put("kampusName", cursor.getString(1));
                map.put("alamat", cursor.getString(2));
                kampusList.add(map);
            } while (cursor.moveToNext());
        }

        // return contact list
        return kampusList;
    }

    public HashMap<String, String> getKampusInfo(String id) {
        HashMap<String, String> kampusList = new HashMap<String, String>();
        SQLiteDatabase database = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM kampus where kampusId='"+id+"'";
        Cursor cursor = database.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                //HashMap<String, String> map = new HashMap<String, String>();
                kampusList.put("kampusName", cursor.getString(1));
                kampusList.put("alamat", cursor.getString(2));
                //wordList.add(map);
            } while (cursor.moveToNext());
        }
        return kampusList;
    }
}
