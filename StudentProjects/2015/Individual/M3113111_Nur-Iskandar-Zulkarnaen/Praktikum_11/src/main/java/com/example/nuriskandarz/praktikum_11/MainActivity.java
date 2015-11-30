package com.example.nuriskandarz.praktikum_11;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends ListActivity implements android.view.View.OnClickListener{

    Button btnAdd,btnGetAll;
    TextView biodata_Id;

    @Override
    public void onClick(View view) {
        if (view== findViewById(R.id.btnAdd)){

            Intent intent = new Intent(this,BiodataDetail.class);
            intent.putExtra("biodata_Id",0);
            startActivity(intent);

        }else {

            BiodataRepo repo = new BiodataRepo(this);

            ArrayList<HashMap<String, String>> studentList =  repo.getbiodataList();
            if(studentList.size()!=0) {
                ListView lv = getListView();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                        biodata_Id = (TextView) view.findViewById(R.id.biodata_Id);
                        String studentId = biodata_Id.getText().toString();
                        Intent objIndent = new Intent(getApplicationContext(),BiodataDetail.class);
                        objIndent.putExtra("biodata_Id", Integer.parseInt( studentId));
                        startActivity(objIndent);
                    }
                });
                ListAdapter adapter = new SimpleAdapter( MainActivity.this,studentList, R.layout.view_biodata_entry, new String[] { "id","nama"}, new int[] {R.id.biodata_Id, R.id.biodata_nama});
                setListAdapter(adapter);
            }else{
                Toast.makeText(this, "Tidak ada data biodata!", Toast.LENGTH_SHORT).show();
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnGetAll = (Button) findViewById(R.id.btnGetAll);
        btnGetAll.setOnClickListener(this);

    }


}