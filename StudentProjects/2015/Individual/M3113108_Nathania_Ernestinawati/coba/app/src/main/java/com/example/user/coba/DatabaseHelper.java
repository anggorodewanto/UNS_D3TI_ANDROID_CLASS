package com.example.user.coba;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 17/11/2015.
 */
public class DatabaseHelper {

    public static final String MYDATABASE_NAME ="database_tania";
    public static final String MYDATABASE_TABLE = "userku";
    public static final int MYDATABASE_VERSION = 1;
    public static final String KEY_ID ="_id";
    public static final String KEY_CONTENT = "Content";
    private static final String SCRIPT_CREATE_DATABASE =
            "create table " + MYDATABASE_TABLE + " (" + KEY_ID + " integer primary key autoincrement, "+ KEY_CONTENT + " text not null);";
    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Context context;
    public DatabaseHelper(Context c){
        context = c;
    }
    public DatabaseHelper mauBaca() throws android.database.SQLException {
        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getReadableDatabase();
        return this;
    }
    public DatabaseHelper mauNulis() throws android.database.SQLException {
        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NAME, null, MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        return this;
    }
    public void close(){
        sqLiteHelper.close();
    }
    public long insert(String content){
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_CONTENT, content);
        return sqLiteDatabase.insert(MYDATABASE_TABLE, null, contentValues);
    }
    public Cursor queueAll(){
        String[] columns = new String[]{KEY_ID, KEY_CONTENT};
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_TABLE, columns,
                null, null, null, null, null);
        return cursor;
    }
    public class SQLiteHelper extends SQLiteOpenHelper {
        public SQLiteHelper(Context context, String name,
                            SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
// TODO Auto-generated method stub
            db.execSQL(SCRIPT_CREATE_DATABASE);
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub
        }
    }
}
