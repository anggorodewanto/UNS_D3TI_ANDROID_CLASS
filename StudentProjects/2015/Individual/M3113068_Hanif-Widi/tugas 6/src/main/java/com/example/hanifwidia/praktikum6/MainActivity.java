package com.example.hanifwidia.praktikum6;

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
    private Button btnDelete;
    private EditText editText;
    private ListView listView;
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button)findViewById(R.id.addTaskBtn);
        btnAdd.setOnClickListener(this);
        btnDelete = (Button)findViewById(R.id.DeleteButton);
        btnDelete.setOnClickListener(this);
        editText = (EditText)findViewById(R.id.editText);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);

        // set the lv variable to your list in the xml
        listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

    int position;
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.addTaskBtn:
                String input = editText.getText().toString();
                if(input.length() > 0)
                {
                    // add string to the adapter, not the listview
                    adapter.add(input);
                    // no need to call adapter.notifyDataSetChanged(); as it is done by the adapter.add() method
                    editText.setText("");
                }
                break;
            case R.id.DeleteButton:
                list.remove(position);
                editText.setText("");
                listView.setAdapter(adapter);
            default:
                break;
        }
    }

}
