package com.example.nuriskandarz.praktikum_11;

/**
 * Created by Nur Iskandar Z on 30/11/2015.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class BiodataRepo {
    private DBHelper dbHelper;

    public BiodataRepo(Context context) {
        dbHelper = new DBHelper(context);
    }

    public int insert(Biodata biodata) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Biodata.KEY_alamat, biodata.alamat);
        values.put(Biodata.KEY_nama,biodata.nama);


        long biodata_Id = db.insert(Biodata.TABLE, null, values);
        db.close();
        return (int) biodata_Id;
    }

    public void delete(int biodata_Id) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(Biodata.TABLE, Biodata.KEY_ID + "= ?", new String[] { String.valueOf(biodata_Id) });
        db.close();
    }

    public void update(Biodata biodata) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(Biodata.KEY_alamat, biodata.alamat);
        values.put(Biodata.KEY_nama,biodata.nama);

        db.update(Biodata.TABLE, values, Biodata.KEY_ID + "= ?", new String[] { String.valueOf(biodata.biodata_ID) });
        db.close();
    }

    public ArrayList<HashMap<String, String>>  getbiodataList() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Biodata.KEY_ID + "," +
                Biodata.KEY_nama + "," +
                Biodata.KEY_alamat +
                " FROM " + Biodata.TABLE;

        ArrayList<HashMap<String, String>> biodataList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> biodata = new HashMap<String, String>();
                biodata.put("id", cursor.getString(cursor.getColumnIndex(Biodata.KEY_ID)));
                biodata.put("nama", cursor.getString(cursor.getColumnIndex(Biodata.KEY_nama)));
                biodataList.add(biodata);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return biodataList;

    }

    public Biodata getbiodataById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Biodata.KEY_ID + "," +
                Biodata.KEY_nama + "," +
                Biodata.KEY_alamat +
                " FROM " + Biodata.TABLE
                + " WHERE " +
                Biodata.KEY_ID + "=?";

        int iCount =0;
        Biodata biodata = new Biodata();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                biodata.biodata_ID =cursor.getInt(cursor.getColumnIndex(Biodata.KEY_ID));
                biodata.nama =cursor.getString(cursor.getColumnIndex(Biodata.KEY_nama));
                biodata.alamat  =cursor.getString(cursor.getColumnIndex(Biodata.KEY_alamat));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return biodata;
    }

}