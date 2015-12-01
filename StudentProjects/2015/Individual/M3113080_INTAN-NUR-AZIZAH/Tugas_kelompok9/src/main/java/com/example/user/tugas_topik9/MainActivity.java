package com.example.user.tugas_topik9;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity {
    Intent intent;
    TextView kampusId;
    DBController controller = new DBController(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<HashMap<String, String>> kampusList =  controller.getAllkampus();
        if(kampusList.size()!=0) {
            ListView lv = getListView();
            lv.setOnItemClickListener(new OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                    kampusId = (TextView) view.findViewById(R.id.kampusId);
                    String valkampusId = kampusId.getText().toString();
                    Intent  objIndent = new Intent(getApplicationContext(),
                            EditKampusActivity.class);
                    objIndent.putExtra("kampusId", valkampusId);
                    startActivity(objIndent);
                }
            });
            ListAdapter adapter =
                    new SimpleAdapter( MainActivity.this,kampusList, R.layout.view_kampus_entry, new String[]
                            { "kampusId","kampusName","alamat"}, new int[]
                            {R.id.kampusId, R.id.kampusName,R.id.alamat});
            setListAdapter(adapter);
        }
    }
    public void showAddForm(View view) {
        Intent objIntent = new Intent(getApplicationContext(), NewKampusActivity.class);
        startActivity(objIntent);
    }
}
