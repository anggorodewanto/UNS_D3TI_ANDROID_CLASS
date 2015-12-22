<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
package com.example.luby.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private String[] bulan = {"Januari","Februari","Maret",
            "April","Mei","Juni","Juli",
            "Agustus","September","Oktober",
            "Nopember","Desember"};
    private ListView list1;
    private ArrayAdapter<String> adapter;
    private OnItemClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1 = (ListView) findViewById(R.id.listView1);

        //membuat adapter agar item bulan menempel pada listview
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                bulan);
        //menerapkan adapter pada objek list1
        list1.setAdapter(adapter);

        //membuat listener ketika item pada listview diklik
        listener = new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0,
                                    View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this,
                        "Anda memilih bulan "+bulan[arg2],
                        Toast.LENGTH_SHORT).show();
            }
        };

        //menerapkan listener pada objek list1
        list1.setOnItemClickListener(listener);
    }
=======
=======
>>>>>>> 9bcb1ee2d8e6be1302c65f1846f3d44c306f3281
=======
>>>>>>> 96221baf653956e2971c838250949b1475d49392
=======
>>>>>>> 1178101a612ad988492ac1e65cd04cd8adcd5eb0
package com.example.luby.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private String[] bulan = {"Januari","Februari","Maret",
            "April","Mei","Juni","Juli",
            "Agustus","September","Oktober",
            "Nopember","Desember"};
    private ListView list1;
    private ArrayAdapter<String> adapter;
    private OnItemClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1 = (ListView) findViewById(R.id.listView1);

        //membuat adapter agar item bulan menempel pada listview
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                bulan);
        //menerapkan adapter pada objek list1
        list1.setAdapter(adapter);

        //membuat listener ketika item pada listview diklik
        listener = new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0,
                                    View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this,
                        "Anda memilih bulan "+bulan[arg2],
                        Toast.LENGTH_SHORT).show();
            }
        };

        //menerapkan listener pada objek list1
        list1.setOnItemClickListener(listener);
    }
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 8db45b5cea6a230fa4caf7c986c806387699db05
=======
package com.example.luby.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
    private String[] bulan = {"Januari","Februari","Maret",
            "April","Mei","Juni","Juli",
            "Agustus","September","Oktober",
            "Nopember","Desember"};
    private ListView list1;
    private ArrayAdapter<String> adapter;
    private OnItemClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list1 = (ListView) findViewById(R.id.listView1);

        //membuat adapter agar item bulan menempel pada listview
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1,
                bulan);
        //menerapkan adapter pada objek list1
        list1.setAdapter(adapter);

        //membuat listener ketika item pada listview diklik
        listener = new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0,
                                    View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                Toast.makeText(MainActivity.this,
                        "Anda memilih bulan "+bulan[arg2],
                        Toast.LENGTH_SHORT).show();
            }
        };

        //menerapkan listener pada objek list1
        list1.setOnItemClickListener(listener);
    }
>>>>>>> 9a0b63e75630e1d7eda9b90d52fd2e86c57e4b89
=======
>>>>>>> 9bcb1ee2d8e6be1302c65f1846f3d44c306f3281
=======
>>>>>>> 96221baf653956e2971c838250949b1475d49392
=======
>>>>>>> 1178101a612ad988492ac1e65cd04cd8adcd5eb0
}