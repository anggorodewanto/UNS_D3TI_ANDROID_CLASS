package com.example.user.tugas_topik9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;

/**
 * Created by User on 30/11/2015.
 */
public class EditKampusActivity extends Activity {
    EditText txtKampusName,txtEditAlamat;
    DBController controller = new DBController(this);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_kampus);
        txtKampusName = (EditText) findViewById(R.id.txtKampusName);
        txtEditAlamat = (EditText) findViewById(R.id.txtEditAlamat);
        Intent objIntent = getIntent();
        String kampusId = objIntent.getStringExtra("kampusId");
        Log.d("Reading: ", "Reading all kampus..");
        HashMap<String, String> kampusList = controller.getKampusInfo(kampusId);
        Log.d("kampusName",kampusList.get("kampusName"));
        if(kampusList.size()!=0) {
            txtKampusName.setText(kampusList.get("kampusName"));
            txtEditAlamat.setText(kampusList.get("alamat"));
        }
    }
    public void editKampus(View view) {
        HashMap<String, String> queryValues =  new  HashMap<String, String>();
        txtKampusName = (EditText) findViewById(R.id.txtKampusName);
        txtEditAlamat = (EditText) findViewById(R.id.txtEditAlamat);
        Intent objIntent = getIntent();
        String kampusId = objIntent.getStringExtra("kampusId");
        queryValues.put("kampusId", kampusId);
        queryValues.put("kampusName", txtKampusName.getText().toString());
        queryValues.put("alamat", txtEditAlamat.getText().toString());

        controller.updateKampus(queryValues);
        this.callHomeActivity(view);

    }
    public void removeKampus(View view) {
        Intent objIntent = getIntent();
        String kampusId = objIntent.getStringExtra("kampusId");
        controller.deleteKampus(kampusId);
        this.callHomeActivity(view);

    }
    public void callHomeActivity(View view) {
        Intent objIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(objIntent);
    }
}




