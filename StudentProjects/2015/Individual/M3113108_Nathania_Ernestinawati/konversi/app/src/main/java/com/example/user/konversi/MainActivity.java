package com.example.user.konversi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewGroup;
import android.app.ActionBar;
//import android.text.InputType;
import android.view.Gravity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView judul = new TextView(this);
        final TextView jawaban = new TextView(this);
        final EditText kotak = new EditText(this);
        Button tombol = new Button(this);
        tombol.setGravity(Gravity.CENTER);
        kotak.setGravity(Gravity.CENTER);
        judul.setText("Konversi Celcius to Fahrenheit");
        tombol.setText("Hitung");
        LinearLayout layar = new LinearLayout(this);

        layar.setLayoutParams(new ActionBar.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
        kotak.setLayoutParams(new ActionBar.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
        judul.setLayoutParams(new ActionBar.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));
        tombol.setLayoutParams(new ActionBar.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT));

        layar.setOrientation(LinearLayout.VERTICAL);
        layar.setGravity(Gravity.CENTER);

        layar.addView(judul);
        layar.addView(kotak);
        layar.addView(jawaban);
        layar.addView(tombol);

        tombol.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                float nilai = Float.parseFloat(kotak.getText().toString());
                jawaban.setText(String.valueOf(nilai*9/5+32)+" F");
            }

        });

        setContentView(layar);

        //setContentView(R.layout.activity_main);
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
