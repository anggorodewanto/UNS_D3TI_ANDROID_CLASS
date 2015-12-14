package com.example.paul.database;

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

public class MainActivity extends ListActivity implements View.OnClickListener {
    Button btnAdd,btnGetAll;
    TextView student_Id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnGetAll = (Button) findViewById(R.id.btnGetAll);
        btnGetAll.setOnClickListener(this);
    }

   /* @Override
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
    }*/

    @Override
    public void onClick(View view) {
        if (view== findViewById(R.id.btnAdd)){

            Intent intent = new Intent(this,StudentDetail.class);
            intent.putExtra("student_Id",0);
            startActivity(intent);

        }else {

            StudentRepo repo = new StudentRepo(this);

            ArrayList<HashMap<String, String>> studentList =  repo.getStudentList();
            if(studentList.size()!=0) {
                ListView lv = getListView();
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                        student_Id = (TextView) view.findViewById(R.id.student_Id);
                        String studentId = student_Id.getText().toString();
                        Intent objIndent = new Intent(getApplicationContext(),StudentDetail.class);
                        objIndent.putExtra("student_Id", Integer.parseInt( studentId));
                        startActivity(objIndent);
                    }
                });
                ListAdapter adapter = new SimpleAdapter( MainActivity.this,studentList, R.layout.student_entry, new String[] { "id","name"}, new int[] {R.id.student_Id, R.id.student_name});
                setListAdapter(adapter);
            }else{
                Toast.makeText(this, "No student!", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
