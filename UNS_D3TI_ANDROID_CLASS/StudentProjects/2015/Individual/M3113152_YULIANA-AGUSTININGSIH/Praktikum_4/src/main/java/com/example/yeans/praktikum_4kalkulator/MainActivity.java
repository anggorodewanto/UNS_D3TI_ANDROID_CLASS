package com.example.yeans.praktikum_4kalkulator;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView title = new TextView(this);
        TextView title2 = new TextView(this);
        TextView title3 = new TextView(this);
        TextView title4 = new TextView(this);
        final EditText input1 = new EditText(this);
        final EditText input2 = new EditText(this);
        Button tambah = new Button(this);
        Button kurang = new Button(this);
        Button bagi = new Button(this);
        Button kali = new Button(this);
        final TextView hasil = new TextView(this);

        title.setText("KALKULATOR SEDERHANA");
        title.setTextSize(20);
        title.setGravity(Gravity.CENTER);
        title2.setText("Masukkan angka ke - 1");
        title2.setTextSize(16);
        title3.setText("Masukkan angka ke - 2");
        title3.setTextSize(16);
        title4.setText("Hasil");
        title4.setTextSize(16);
        input1.setInputType(InputType.TYPE_CLASS_NUMBER);
        input1.setGravity(Gravity.CENTER);
        input2.setInputType(InputType.TYPE_CLASS_NUMBER);
        input2.setGravity(Gravity.CENTER);
        tambah.setGravity(Gravity.CENTER);
        tambah.setText("+");
        kurang.setGravity(Gravity.CENTER);
        kurang.setText("-");
        bagi.setGravity(Gravity.CENTER);
        bagi.setText("/");
        kali.setGravity(Gravity.CENTER);
        kali.setText("*");

        LinearLayout tampil = new LinearLayout(this);
        LinearLayout tampil2 = new LinearLayout(this);

        tampil.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        title.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        title2.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        title3.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        title4.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        input1.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        input2.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        tambah.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        kurang.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        kali.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        bagi.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        tampil.setOrientation(LinearLayout.VERTICAL);
        tampil.setGravity(Gravity.CENTER);
        tampil2.setOrientation(LinearLayout.HORIZONTAL);
        tampil2.setGravity(Gravity.CENTER);

        tampil.addView(title);
        tampil.addView(title2);
        tampil.addView(input1);
        tampil.addView(title3);
        tampil.addView(input2);
        tampil.addView(tampil2);
        tampil2.addView(tambah);
        tampil2.addView(kurang);
        tampil2.addView(kali);
        tampil2.addView(bagi);
        tampil.addView(title4);
        tampil.addView(hasil);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float nilai1 = Float.parseFloat(input1.getText().toString());
                float nilai2 = Float.parseFloat(input2.getText().toString());
                hasil.setText("hasil penjumlahan = " + String.valueOf(nilai1 + nilai2));
            }
        });

        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float nilai1 = Float.parseFloat(input1.getText().toString());
                float nilai2 = Float.parseFloat(input2.getText().toString());
                hasil.setText("hasil pengurangan = " + String.valueOf( nilai1 - nilai2 ));
            }
        });

        bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float nilai1 = Float.parseFloat(input1.getText().toString());
                float nilai2 = Float.parseFloat(input2.getText().toString());
                hasil.setText("hasil pembagian = " + String.valueOf( nilai1 / nilai2 ));
            }
        });

        kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float nilai1 = Float.parseFloat(input1.getText().toString());
                float nilai2 = Float.parseFloat(input2.getText().toString());
                hasil.setText("hasil perkalian = " + String.valueOf( nilai1 * nilai2 ));
            }
        });

        setContentView(tampil);
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
