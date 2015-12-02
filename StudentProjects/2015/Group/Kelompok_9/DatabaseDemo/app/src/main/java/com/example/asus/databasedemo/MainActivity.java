package com.example.asus.databasedemo;


import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    Dbase db;
    Button tombolSimpan;
    EditText editNama, editTanggal;
    CheckBox cekJender;
    ListView listViewData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buat objek database
        db = new Dbase(this);

        // Objek komponen
        editNama = (EditText) findViewById(R.id.editTextNama);
        editTanggal = (EditText) findViewById(R.id.editTextTgLahir);
        cekJender = (CheckBox) findViewById(R.id.checkBoxPria);
        cekJender = (CheckBox) findViewById(R.id.checkBoxWanita);
        listViewData = (ListView) findViewById(R.id.listViewDb);

        tombolSimpan = (Button) findViewById(R.id.buttonSimpan);
        tombolSimpan.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                db.open();
                db.insertData(editNama.getText().toString(),
                        cekJender.isChecked(),
                        editTanggal.getText().toString());
                db.close();

                Toast.makeText(getBaseContext(),
                        "Data telah disimpan",
                        Toast.LENGTH_SHORT).show();

                // Kosongkan data
                editNama.setText("");
                cekJender.setChecked(false);
                editTanggal.setText("");

                // Tampilkan data di database
                tampilkanData();
            }

        });

        tampilkanData();
    }

    public void tampilkanData() {
        db.open();
        Cursor c = db.getAllData();

        // Buat array dinamis
        ArrayList<String> larik = new ArrayList<String>();

        if (c.moveToFirst()) {
            do {
                int idMahasiswa = c.getInt(0);
                String namaMahasiswa = c.getString(1);
                int jenderMahasiswa = c.getInt(2);
                String tgLahir = c.getString(3);

                String kelamin;
                if (jenderMahasiswa == 1)
                    kelamin = "Wanita";
                else if (jenderMahasiswa == 2)
                    kelamin = "";
                else
                    kelamin = "Pria";

                larik.add(Integer.toString(idMahasiswa) + ": " +
                        namaMahasiswa + " (" + kelamin + ") - " +
                        tgLahir);
            } while (c.moveToNext());
        }

        db.close();

        // Taruh larik ke Listview

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                larik);

        listViewData.setAdapter(adapter);

    }


}
