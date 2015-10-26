package com.example.user.listviewtugas;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button tambah = (Button) findViewById(R.id.add);
        final Button hapus = (Button) findViewById(R.id.delete);

        final ListView myListView = (ListView) findViewById(R.id.lv);
        final EditText editText = (EditText) findViewById(R.id.editText);

        final ArrayList<String> al = new ArrayList<String>();
        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, al);
        myListView.setAdapter(adapter);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                Integer count = myListView.getCount() + 1;
                String str1 = count.toString().concat(". " + str);
                al.add(myListView.getCount(), str1);
                //Collections.sort(al);
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_SHORT).show();
                editText.setText(" ");
            }
        });

        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                al.remove(al.size() - 1);
                adapter.notifyDataSetChanged();
            }
        });
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