package github.listview;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends ListActivity {

    ArrayList List = new ArrayList();
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.btnAdd);
        Button btnDel = (Button) findViewById(R.id.btnDel);

        adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_activated_1, List);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edit = (EditText) findViewById(R.id.txtItem);
                List.add(edit.getText().toString());
                edit.setText("");
                adapter.notifyDataSetChanged();
            }

        };

        View.OnClickListener listenerDel = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SparseBooleanArray checkedItemPositions = getListView().getCheckedItemPositions();
                int itemCount = getListView().getCount();

                for(int i=itemCount-1; i >= 0; i--){
                    if(checkedItemPositions.get(i)){
                        adapter.remove(List.get(i));
                    }
                }
                checkedItemPositions.clear();
                adapter.notifyDataSetChanged();
            }
        };

        btn.setOnClickListener(listener);
        btnDel.setOnClickListener(listenerDel);
        setListAdapter(adapter);
    }


}
