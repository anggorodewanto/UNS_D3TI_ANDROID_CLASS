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
}