package com.example.windows7.celcius_without_xml;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EditText teks1;
        LinearLayout layout1;
        Button tombol1;
        TextView output,judul;

        layout1=new LinearLayout(this);
        layout1.setOrientation(LinearLayout.VERTICAL);

        judul=new TextView(this);
        judul.setText("Convert Celcius to Fahrenheit");

        teks1=new EditText(this);
        teks1.setHint("Enter celsius :");
        teks1.setInputType(3);

        tombol1=new Button(this);
        tombol1.setText("Convert");

        layout1.addView(judul);
        layout1.addView(teks1);
        layout1.addView(tombol1);

        teks1.setId(R.id.editText1);

        output=new TextView(this);
        layout1.addView(output);

        output.setId(R.id.text1);
        tombol1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText teks1 =  (EditText)findViewById(R.id.editText1);
                final TextView output =  (TextView)findViewById(R.id.text1);

                String value1 = teks1.getText().toString();
                int i = Integer.parseInt(value1);
                double d = ((1.8 * i) + 32);
                String out = String.valueOf(d)+" F";
                output.setText(out);
            }
        });
        setContentView(layout1);
    }
}