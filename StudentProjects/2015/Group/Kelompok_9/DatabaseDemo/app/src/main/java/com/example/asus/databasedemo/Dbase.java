package com.example.asus.databasedemo;

/**
 * Created by ASUS on 22/11/2015.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class Dbase {
    private SQLiteDatabase db;
    private final Context konteks;
    private final DBHelper dbhelper;

    // Konstruktor
    public Dbase(Context k) {
        konteks = k;
        dbhelper = new DBHelper(konteks, Konstanta.NAMA_DB,
                null, Konstanta.VERSI_DB);
    }

    // Membuka database
    public void open() throws SQLiteException {
        try {
            db = dbhelper.getWritableDatabase();
        }
        catch (SQLiteException e) {
            db = dbhelper.getReadableDatabase();
        }
    }

    // Menutup database
    public void close() {
        db.close();
    }

    // Menyisipkan data
    public long insertData(String nama, boolean jender, String tanggal) {
        try {
            ContentValues dataBaru = new ContentValues();
            dataBaru.put(Konstanta.NAMA_MAHASISWA, nama);
            dataBaru.put(Konstanta.JENDER_MAHASISWA, jender);
            dataBaru.put(Konstanta.TGLAHIR_MAHASISWA, tanggal);

            return db.insert(Konstanta.NAMA_TABEL, null, dataBaru);
        }
        catch (SQLiteException e) {
            return -1;
        }
    }

    // Menghapus data menurut kunci
    public boolean deleteData(long kunci) {
        return db.delete(Konstanta.NAMA_TABEL,
                Konstanta.ID_MAHASISWA +  "=" + kunci, null) > 0;
    }

    // Mengambil seluruh data
    public Cursor getAllData() {
        return db.query(Konstanta.NAMA_TABEL,
                new String[] {Konstanta.ID_MAHASISWA,
                        Konstanta.NAMA_MAHASISWA,
                        Konstanta.JENDER_MAHASISWA,
                        Konstanta.TGLAHIR_MAHASISWA },
                null, null, null, null, null);
    }

    // Mengambil data berdasarkan penggalan nama
    public Cursor getName(String nama) {
        Cursor c = db.query(Konstanta.NAMA_TABEL,
                new String[] { Konstanta.ID_MAHASISWA,
                        Konstanta.NAMA_MAHASISWA,
                        Konstanta.JENDER_MAHASISWA,
                        Konstanta.TGLAHIR_MAHASISWA },
                Konstanta.NAMA_MAHASISWA + " LIKE '%" + nama + "%'",
                null, null, null, null);
        if (c != null)
            c.moveToFirst();

        return c;
    }

    // Mengambil data berdasarkan kunci
    public Cursor getData(long kunci) {
        Cursor c = db.query(Konstanta.NAMA_TABEL,
                new String[] { Konstanta.NAMA_MAHASISWA,
                        Konstanta.JENDER_MAHASISWA,
                        Konstanta.TGLAHIR_MAHASISWA},
                Konstanta.ID_MAHASISWA + "=" + kunci,
                null, null, null, null);
        if (c != null)
            c.moveToFirst();

        return c;
    }

    // Mengubah data
    public boolean updateData(long kunci, String nama,
                              boolean jender, String tgLahir) {
        ContentValues cv = new ContentValues();
        cv.put(Konstanta.NAMA_MAHASISWA, nama);
        cv.put(Konstanta.JENDER_MAHASISWA, jender);
        cv.put(Konstanta.TGLAHIR_MAHASISWA, tgLahir);

        return db.update(Konstanta.NAMA_TABEL, cv,
                Konstanta.ID_MAHASISWA + "=" + kunci, null) > 0;
    }
}