package com.example.user.kelompok9_tugas;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity {

    Intent intent;
    TextView kampusId;
    com.example.user.kelompok9_tugas.dbController controller = new com.example.user.kelompok9_tugas.dbController(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<HashMap<String, String>> kampusList =  controller.getAllkampus();
        if(kampusList.size()!=0) {
            ListView lv = getListView();
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    kampusId = (TextView) view.findViewById(R.id.kampusId);
                    String valkampusId = kampusId.getText().toString();
                    Intent  objIndent = new Intent(getApplicationContext(),
                            com.example.user.kelompok9_tugas.editKampus.class);
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
        Intent objIntent = new Intent(getApplicationContext(), com.example.user.kelompok9_tugas.newKampus.class);
        startActivity(objIntent);
    }
}
