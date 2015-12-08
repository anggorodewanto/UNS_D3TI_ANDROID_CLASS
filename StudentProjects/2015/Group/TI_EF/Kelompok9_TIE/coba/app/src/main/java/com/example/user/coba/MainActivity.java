package com.example.user.coba;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper mySQLiteAdapter;

        EditText nama;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mySQLiteAdapter = new DatabaseHelper(this);
    }

    public void menuawal(View view) {
        switch (view.getId()) {
            case R.id.inputdata:
                setContentView(R.layout.input);
                Button tambah = (Button) findViewById(R.id.simpan);
                nama = (EditText) findViewById(R.id.nama);
                tambah.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mySQLiteAdapter.mauNulis();
                        mySQLiteAdapter.insert(nama.getText().toString());
                        mySQLiteAdapter.close();
                        setContentView(R.layout.activity_main);
                    }
                });
                break;
            case R.id.listdata:
                setContentView(R.layout.list);
                ListView listContent = (ListView) findViewById(R.id.listuser);
                mySQLiteAdapter = new DatabaseHelper(this);
                mySQLiteAdapter.mauBaca();
                Cursor cursor = mySQLiteAdapter.queueAll();
                startManagingCursor(cursor);
                String[] from = new String[]{DatabaseHelper.KEY_CONTENT};
                int[] to = new int[]{R.id.iniisi};
                SimpleCursorAdapter cursorAdapter =
                        new SimpleCursorAdapter(this, R.layout.isi, cursor, from, to);
                listContent.setAdapter(cursorAdapter);
                mySQLiteAdapter.close();
                break;
        }
    }

    public void getBack(View view) {
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
// Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}
