package com.example.nuriskandarz.praktikum_11;

/**
 * Created by Nur Iskandar Z on 30/11/2015.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BiodataDetail extends ActionBarActivity implements android.view.View.OnClickListener{

    Button btnSave ,  btnDelete;
    Button btnClose;
    EditText editTextNama;
    EditText editTextAlamat;
    private int _Biodata_Id=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biodata_detail);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnClose = (Button) findViewById(R.id.btnClose);


        editTextNama = (EditText) findViewById(R.id.editTextNama);
        editTextAlamat = (EditText) findViewById(R.id.editTextAlamat);

        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClose.setOnClickListener(this);


        _Biodata_Id =0;
        Intent intent = getIntent();
        _Biodata_Id =intent.getIntExtra("biodata_Id", 0);
        BiodataRepo repo = new BiodataRepo(this);
        Biodata biodata = new Biodata();
        biodata = repo.getbiodataById(_Biodata_Id);


        editTextNama.setText(biodata.nama);
        editTextAlamat.setText(biodata.alamat);
    }



    public void onClick(View view) {
        if (view == findViewById(R.id.btnSave)){
            BiodataRepo repo = new BiodataRepo(this);
            Biodata biodata = new Biodata();
            biodata.alamat=editTextAlamat.getText().toString();
            biodata.nama=editTextNama.getText().toString();
            biodata.biodata_ID=_Biodata_Id;


            if (_Biodata_Id==0){
                _Biodata_Id = repo.insert(biodata);

                Toast.makeText(this,"New Biodata Insert",Toast.LENGTH_SHORT).show();
            }else{

                repo.update(biodata);
                Toast.makeText(this,"Biodata Record updated",Toast.LENGTH_SHORT).show();
            }
        }else if (view== findViewById(R.id.btnDelete)){
            BiodataRepo repo = new BiodataRepo(this);
            repo.delete(_Biodata_Id);
            Toast.makeText(this, "Biodata Record Deleted", Toast.LENGTH_SHORT);
            finish();
        }else if (view== findViewById(R.id.btnClose)){
            finish();
        }


    }

}