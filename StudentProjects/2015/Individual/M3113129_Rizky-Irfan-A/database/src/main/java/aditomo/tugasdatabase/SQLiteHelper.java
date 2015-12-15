package aditomo.tugasdatabase;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by HP on 11/30/2015.
 */

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final String nama_database = "database_pemain.db";
    private static final int versi_database = 1;
    private static final String query_buat_tabel_biodata_pemain = "CREATE TABLE IF NOT EXISTS tabel_biodata(id_biodata INTEGER PRIMARY KEY AUTOINCREMENT, nama TEXT,alamat TEXT)";
    private static final String query_hapus_tabel_biodata_pemain = "DROP TABLE IF EXISTS query_buat_tabel_biodata_pemain";

    public SQLiteHelper(Context context) {
        super(context, nama_database, null, versi_database);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(query_buat_tabel_biodata_pemain);
        System.out.println("Tabel_biodata telah dibuat");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int versi_lama, int versi_baru) {
        database.execSQL(query_hapus_tabel_biodata_pemain);
        onCreate(database);

    }

    public void tambah_biodata(String nama, String alamat) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("Nama", nama);
        values.put("Alamat", alamat);
        database.insert("tabel_biodata", null, values);
        database.close();
    }

    public ArrayList<HashMap<String, String>> tampil_semua_biodata() {
        SQLiteDatabase database = this.getWritableDatabase();

        ArrayList<HashMap<String, String>> arrayListBiodata = new ArrayList<HashMap<String, String>>();

        Cursor cursor = database.rawQuery("SELECT * FROM tabel_biodata", null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> hashMapBiodata = new HashMap<String, String>();

                hashMapBiodata.put("id_biodata", cursor.getString(0));
                hashMapBiodata.put("Nama", cursor.getString(1));
                hashMapBiodata.put("Alamat", cursor.getString(2));

                arrayListBiodata.add(hashMapBiodata);

            } while (cursor.moveToNext());
        }

        return arrayListBiodata;
    }

    public int update_biodata(int id, String nama, String alamat) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues recordBiodata = new ContentValues();
        recordBiodata.put("Nama", nama);
        recordBiodata.put("Alamat", alamat);
        return database.update("tabel_biodata", recordBiodata, "id_biodata=" + id, null);
    }

    public void hapus_biodata(int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL("DELETE FROM  tabel_biodata WHERE id_biodata='" + id+ "'");
        database.close();
    }

    public HashMap<String, String> tampil_biodata_berdasarkan_id(int id) {
        SQLiteDatabase database = this.getReadableDatabase();

        HashMap<String, String> hashMapBiodata = new HashMap<String, String>();
        Cursor cursor = database.rawQuery("SELECT * FROM tabel_biodata WHERE id_biodata=" + id + "", null);

        if (cursor.moveToFirst()) {
            do {
                hashMapBiodata.put("id_biodata", cursor.getString(0));
                hashMapBiodata.put("Nama", cursor.getString(1));
                hashMapBiodata.put("Alamat", cursor.getString(2));
            } while (cursor.moveToNext());
        }

        return hashMapBiodata;
    }

}
