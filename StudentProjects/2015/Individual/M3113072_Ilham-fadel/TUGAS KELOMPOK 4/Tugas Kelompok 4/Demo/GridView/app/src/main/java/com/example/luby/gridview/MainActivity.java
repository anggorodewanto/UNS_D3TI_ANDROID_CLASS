package com.example.luby.gridview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class MainActivity extends Activity {
    private String[] bulan = {"Januari","Februari","Maret",
            "April","Mei","Juni","Juli",
            "Agustus","September","Oktober",
            "Nopember","Desember"};

    private GridView grid1;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid1 = (GridView) findViewById(R.id.gridView1);

        //membuat adapter agar item bulan menempel pada gridview
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                bulan);
        //menerapkan adapter pada objek grid1
        grid1.setAdapter(adapter);

        //penggunaan listenernya mirip dengan listener pada listview
    }

}
