package com.example.setiadidarmawan.addlistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button BtAdd = (Button) findViewById(R.id.add);
        final Button BtDel = (Button) findViewById(R.id.delete);

        final ListView LiView = (ListView) findViewById(R.id.livin);
        final EditText EdText = (EditText) findViewById(R.id.main);

        final ArrayList<String> listarray = new ArrayList<String>();
        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listarray);
        LiView.setAdapter(adapter);

        BtAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ready = EdText.getText().toString();
                Integer count = LiView.getCount() + 1;
                String start = count.toString().concat("." + ready);
                listarray.add(LiView.getCount(), start);
                adapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(), "Data Saved", Toast.LENGTH_SHORT).show();
                EdText.setText(" ");
            }
        });
        BtDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listarray.remove(listarray.size() - 1);
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
