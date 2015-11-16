package com.example.roniabdulyasir.tugas_listview;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends Activity {
    ArrayList list = new ArrayList();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.tambah);
        Button btn2 = (Button) findViewById(R.id.delete);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice,list);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
        public void onClick(View v) {
                EditText edit = (EditText) findViewById(R.id.edit);
                list.add(edit.getText().toString());
                edit.setText("");
                adapter.notifyDataSetChanged();
            }
        };
        View.OnClickListener listener1 = new View.OnClickListener() {


            @Override
        public void onClick(View v) {
                /** Getting the checked items from the listview */
                SparseBooleanArray checkedItemPositions = getListView().getCheckedItemPositions();
                int itemCount = getListView().getCount();

                for (int i=itemCount-1; i >= 0; i--){
                    if (checkedItemPositions.get(i)){
                        adapter.remove(list.get(i));
                    }
                }
                checkedItemPositions.clear();
                adapter.notifyDataSetChanged();
            }
        };
        btn.setOnClickListener(listener);
        btn2.setOnClickListener(listener1);
        setListAdapter(adapter);
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
}
