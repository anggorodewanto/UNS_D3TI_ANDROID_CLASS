package com.example.andisaputro.tugaslistview;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;



public class MainActivity extends Activity implements OnClickListener {
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
        btntambah.setOnClickListener(this);
        btnhapus = (Button)findViewById(R.id.button2);
        btnhapus.setOnClickListener(this);
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


    }

    int posisiKontak;

        @Override
        public void onClick(View v) {
            // TODO Auto-generated method stub
            switch (v.getId()) {
                case R.id.button1:

                String input = editNama.getText().toString();
                String inputno = editNomor.getText().toString();
                if(input.length()  > 0)
                {
                    // add string to the adapter, not the listview
                    adapterNama.add(input);
                    adapterNomor.add(inputno);
                    // no need to call adapter.notifyDataSetChanged(); as it is done by the adapter.add() method
                }
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


}