package com.example.user.tugaskelompok4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button Add;
    private Button  Delete;
    private EditText editText;
    private ListView listView;
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Add = (Button)findViewById(R.id.Add);
        Add.setOnClickListener(this);
        Delete = (Button)findViewById(R.id.Delete);
        Delete.setOnClickListener(this);
        editText = (EditText)findViewById(R.id.editText);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);

        // set the lv variable to your list in the xml
        listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    int posisitask;
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.Add:
                String input = editText.getText().toString();
                if(input.length() > 0)
                {
                    // add string to the adapter, not the listview
                    adapter.add(input);
                    // no need to call adapter.notifyDataSetChanged(); as it is done by the adapter.add() method
                }
                break;
            case R.id.Delete:
                list.remove(posisitask);
                editText.setText("");
                listView.setAdapter(adapter);
            default:
                break;
        }
    }
}
