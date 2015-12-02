package com.example.asus.databasedemo;

/**
 * Created by ASUS on 22/11/2015.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DBHelper extends SQLiteOpenHelper {
    // Berisi perintah SQL untuk menciptakan tabel bernama mahasiswa
    private final static String BUAT_TABEL = "create table " +
            Konstanta.NAMA_TABEL + " (" +
            Konstanta.ID_MAHASISWA + " integer primary key autoincrement, " +
            Konstanta.NAMA_MAHASISWA + " text not null, " +
            Konstanta.JENDER_MAHASISWA + " boolean not null, " +
            Konstanta.TGLAHIR_MAHASISWA + " text not null);";

    public DBHelper(Context konteks, String nama,
                    CursorFactory f, int versi) {
        super(konteks, nama, f, versi);
    }

    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(BUAT_TABEL);
        }
        catch (SQLiteException e) {
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versiLama,
                          int versiBaru) {
        db.execSQL("drop tabel if exists " +
                Konstanta.NAMA_TABEL);
        onCreate(db);
    }
}