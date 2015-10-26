package com.alpha.tugaslistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.view.View;
import android.app.Activity;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        final Button input = (Button) findViewById(R.id.add);
        final Button hapus = (Button) findViewById(R.id.delete);
        final ListView listview = (ListView) findViewById(R.id.list);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final ArrayList<String> array = new ArrayList<String>();
        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
        listview.setAdapter(adapter);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                Integer count = listview.getCount() + 1;
                String str1 = count.toString().concat(". " + str);
                array.add(listview.getCount(), str1);
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "simpan", Toast.LENGTH_SHORT).show();
                editText.setText(" ");
            }
        });
        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                array.remove(array.size()-1);
                adapter.notifyDataSetChanged();
            }});
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