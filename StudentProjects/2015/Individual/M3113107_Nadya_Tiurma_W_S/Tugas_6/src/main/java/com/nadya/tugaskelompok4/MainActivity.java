package com.nadya.tugaskelompok4;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;

public class MainActivity extends ListActivity {

    ArrayList<String> items = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnadd = (Button) findViewById(R.id.add);
        Button btndel = (Button) findViewById(R.id.delete);
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, items);

        OnClickListener listener = new OnClickListener() {
            @Override

            public void onClick(View v) {
                EditText edit = (EditText) findViewById(R.id.txtItem);
                items.add(edit.getText().toString());
                edit.setText("");
                adapter.notifyDataSetChanged();
            }
        };

        /** Defining a click event listener for the button "Delete" */
        OnClickListener listenerDel = new OnClickListener() {
            @Override

            public void onClick(View v) {
                /** Getting the checked items from the listview */
                SparseBooleanArray checkedItemPositions = getListView().getCheckedItemPositions();
                int itemCount = getListView().getCount();

                for (int i = itemCount - 1; i >= 0; i--) {
                    if (checkedItemPositions.get(i)) {
                        adapter.remove(items.get(i));
                    }
                }
                checkedItemPositions.clear();
                adapter.notifyDataSetChanged();
            }
        };

        /** Setting the event listener for the add button */
        btnadd.setOnClickListener(listener);

        /** Setting the event listener for the delete button */
        btndel.setOnClickListener(listenerDel);

        /** Setting the adapter to the ListView */
        setListAdapter(adapter);
    }
}