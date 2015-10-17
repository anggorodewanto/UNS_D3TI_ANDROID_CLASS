package com.example.luby.kontak;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ArrayList<String> Nama,Nomor;
    ArrayAdapter<String> adapterNama,adapterNomor;
    Button btntambah, btnhapus;
    EditText editNama, editNomor;
    ListView lsNama, lsNomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btntambah = (Button)findViewById(R.id.button1);
        btnhapus = (Button)findViewById(R.id.button2);
        lsNama = (ListView)findViewById(R.id.ListView1);
        lsNomor = (ListView)findViewById(R.id.ListView2);
        editNama = (EditText)findViewById(R.id.EditText1);
        editNomor = (EditText)findViewById(R.id.EditText2);

        Nama = new ArrayList<String>();
        Nomor = new ArrayList<String>();

        adapterNama = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Nama);
        adapterNomor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Nomor);

        lsNama.setAdapter(adapterNama);
        lsNomor.setAdapter(adapterNomor);

        btntambah.setOnClickListener(clickButton);
        btnhapus.setOnClickListener(clickButton);
        //lsNama.setOnItemClickListener(clickItem);
        //lsNomor.setOnItemClickListener(clickItem);
    }

    int posisiKontak;

    View.OnClickListener clickButton = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.button1:
                    Nama.add(editNama.getText().toString());
                    Nomor.add(editNomor.getText().toString());
                    break;
                case R.id.button2:
                    Nama.remove(posisiKontak);
                    Nomor.remove(posisiKontak);
                    editNama.setText("");
                    editNomor.setText("");
                    lsNama.setAdapter(adapterNama);
                    lsNomor.setAdapter(adapterNomor);

                default:
                    break;
            }
        }
    };

   /* AdapterView.OnItemClickListener clickItem = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            posisiKontak=position;
            editNama.setText(Nama.get(position));
            editNomor.setText(Nomor.get(position));
        }
    };*/
}
