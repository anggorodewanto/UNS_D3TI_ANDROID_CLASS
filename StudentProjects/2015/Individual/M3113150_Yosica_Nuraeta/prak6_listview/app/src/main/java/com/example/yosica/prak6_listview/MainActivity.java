package com.example.yosica.prak6_listview;

import java.util.ArrayList;
import java.util.Collections;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.app.ActionBarActivity;

public class MainActivity extends ActionBarActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button add_btn = (Button)findViewById(R.id.btn_add);
        final Button del_btn = (Button)findViewById(R.id.btn_delete);

        final ListView myListView = (ListView)findViewById(R.id.lv_main);
        final EditText et_main = (EditText)findViewById(R.id.et_main);

        final ArrayList<String> al = new ArrayList<String>();
        final ArrayAdapter<String> ad;
        ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,al);
        myListView.setAdapter(ad);


        add_btn.setOnClickListener(new OnClickListener()
        {

            public void onClick(View v)
            {
                String str = et_main.getText().toString();
                Integer cout = myListView.getCount()+ 1;
                String str1 = cout.toString().concat("."+str);
                al.add(myListView.getCount(), str1);
                //Collections.sort(al);
                ad.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_SHORT).show();
                et_main.setText(" ");
            }
        });
        del_btn.setOnClickListener(new OnClickListener()
        {

            public void onClick(View v)
            {
                al.remove(al.size()-1);
                ad.notifyDataSetChanged();
            }
        });
    }
}

