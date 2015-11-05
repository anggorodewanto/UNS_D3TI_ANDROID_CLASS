package com.example.eko.tugas_kelompok4;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements OnClickListener {

    private Button btnAdd;
    private Button btnDel;
    private EditText et;
    private ListView lv;
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;
    int posisitask;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button)findViewById(R.id.addTaskBtn);
        btnAdd.setOnClickListener(this);
        btnDel = (Button)findViewById(R.id.DeleteButton);
        btnDel.setOnClickListener(this);
        et = (EditText)findViewById(R.id.editText);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);

        // set the lv variable to your list in the xml
        lv=(ListView)findViewById(R.id.list);
        lv.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.addTaskBtn:
                String input = et.getText().toString();
                if(input.length() > 0)
                {
                    // add string to the adapter, not the listview
                    adapter.add(input);
                    // no need to call adapter.notifyDataSetChanged(); as it is done by the adapter.add() method
                }
                break;
            case R.id.DeleteButton:
                list.remove(posisitask);
                et.setText("");
                lv.setAdapter(adapter);
            default:
                break;
        }
    }
}
