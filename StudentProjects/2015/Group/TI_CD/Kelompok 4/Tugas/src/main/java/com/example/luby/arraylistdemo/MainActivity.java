<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
package com.example.luby.arraylistdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnClickListener
{
    private Button btnAdd;
    private EditText et;
    private ListView lv;
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button)findViewById(R.id.addTaskBtn);
        btnAdd.setOnClickListener(this);
        et = (EditText)findViewById(R.id.editText);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);

        // set the lv variable to your list in the xml
        lv=(ListView)findViewById(R.id.list);
        lv.setAdapter(adapter);
    }
    public void onClick(View v)
    {
        String input = et.getText().toString();
        if(input.length() > 0)
        {
            // add string to the adapter, not the listview
            adapter.add(input);
            // no need to call adapter.notifyDataSetChanged(); as it is done by the adapter.add() method
        }
    }
=======
=======
>>>>>>> 9bcb1ee2d8e6be1302c65f1846f3d44c306f3281
=======
>>>>>>> 96221baf653956e2971c838250949b1475d49392
package com.example.luby.arraylistdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnClickListener
{
    private Button btnAdd;
    private EditText et;
    private ListView lv;
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button)findViewById(R.id.addTaskBtn);
        btnAdd.setOnClickListener(this);
        et = (EditText)findViewById(R.id.editText);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);

        // set the lv variable to your list in the xml
        lv=(ListView)findViewById(R.id.list);
        lv.setAdapter(adapter);
    }
    public void onClick(View v)
    {
        String input = et.getText().toString();
        if(input.length() > 0)
        {
            // add string to the adapter, not the listview
            adapter.add(input);
            // no need to call adapter.notifyDataSetChanged(); as it is done by the adapter.add() method
        }
    }
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 8db45b5cea6a230fa4caf7c986c806387699db05
=======
package com.example.luby.arraylistdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnClickListener
{
    private Button btnAdd;
    private EditText et;
    private ListView lv;
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button)findViewById(R.id.addTaskBtn);
        btnAdd.setOnClickListener(this);
        et = (EditText)findViewById(R.id.editText);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);

        // set the lv variable to your list in the xml
        lv=(ListView)findViewById(R.id.list);
        lv.setAdapter(adapter);
    }
    public void onClick(View v)
    {
        String input = et.getText().toString();
        if(input.length() > 0)
        {
            // add string to the adapter, not the listview
            adapter.add(input);
            // no need to call adapter.notifyDataSetChanged(); as it is done by the adapter.add() method
        }
    }
>>>>>>> 9a0b63e75630e1d7eda9b90d52fd2e86c57e4b89
=======
>>>>>>> 9bcb1ee2d8e6be1302c65f1846f3d44c306f3281
=======
>>>>>>> 96221baf653956e2971c838250949b1475d49392
}