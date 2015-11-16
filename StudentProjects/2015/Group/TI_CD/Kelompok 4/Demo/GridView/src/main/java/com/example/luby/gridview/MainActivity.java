<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
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
=======
=======
>>>>>>> 9bcb1ee2d8e6be1302c65f1846f3d44c306f3281
=======
>>>>>>> 96221baf653956e2971c838250949b1475d49392
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
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 8db45b5cea6a230fa4caf7c986c806387699db05
=======
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
>>>>>>> 9a0b63e75630e1d7eda9b90d52fd2e86c57e4b89
=======
>>>>>>> 9bcb1ee2d8e6be1302c65f1846f3d44c306f3281
=======
>>>>>>> 96221baf653956e2971c838250949b1475d49392
