package com.example.alamin.kalkutator2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private double hasilAkhir =0.0 ;
    private String angka1="";
    private String angka2="";
    TextView hasil;
    Button btnJumlah,btnKurang,btnKali,btnBagi;
    EditText edAngka1, edAngka2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edAngka1=(EditText) findViewById(R.id.editangka1);
        edAngka2=(EditText)findViewById(R.id.editangka2);
        hasil=(TextView) findViewById(R.id.trxtHasil);
        btnJumlah=(Button) findViewById(R.id.tambah);
        btnKurang=(Button) findViewById(R.id.kurang);
        btnBagi=(Button) findViewById(R.id.bagi);
        btnKali=(Button) findViewById(R.id.kali);

    }
    public void kliktambah (View v){
        angka1 =edAngka1.getText().toString();
        angka2=edAngka2.getText().toString();

        if(angka1.equalsIgnoreCase("")|| (angka2.equalsIgnoreCase(""))){
            edAngka1.setFocusable(true);
        }else{
            double angkaA= Double.parseDouble(angka1);
            double angkaB= Double.parseDouble(angka2);
            hasilAkhir= angkaA+angkaB;
            String hasilString= String.valueOf(hasilAkhir);
            hasil.setText(hasilString);
        }



    }

    public void klikkurang (View v){
        angka1 =edAngka1.getText().toString();
        angka2=edAngka2.getText().toString();

        if(angka1.equalsIgnoreCase("")|| (angka2.equalsIgnoreCase(""))){
            edAngka1.setFocusable(true);
        }else{
            double angkaA= Double.parseDouble(angka1);
            double angkaB= Double.parseDouble(angka2);
            hasilAkhir= angkaA-angkaB;
            String hasilString= String.valueOf(hasilAkhir);
            hasil.setText(hasilString);
        }
    }

    public void klikbagi (View v) {
        angka1 =edAngka1.getText().toString();
        angka2=edAngka2.getText().toString();

        if(angka1.equalsIgnoreCase("")|| (angka2.equalsIgnoreCase(""))){
            edAngka1.setFocusable(true);
        }else{
            double angkaA= Double.parseDouble(angka1);
            double angkaB= Double.parseDouble(angka2);
            hasilAkhir= angkaA/angkaB;
            String hasilString= String.valueOf(hasilAkhir);
            hasil.setText(hasilString);
        }
    }
    public void klikkali (View v){
        angka1 =edAngka1.getText().toString();
        angka2=edAngka2.getText().toString();

        if(angka1.equalsIgnoreCase("")|| (angka2.equalsIgnoreCase(""))){
            edAngka1.setFocusable(true);
        }else{
            double angkaA= Double.parseDouble(angka1);
            double angkaB= Double.parseDouble(angka2);
            hasilAkhir= angkaA*angkaB;
            String hasilString= String.valueOf(hasilAkhir);
            hasil.setText(hasilString);
        }
    }

    @Override
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
    }
}
