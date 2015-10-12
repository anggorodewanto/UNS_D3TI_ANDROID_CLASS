package com.example.rindym.praktikum_2;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView label = new TextView(this);
        label.setText("Convert Celcius to Fahrenheit");

        final EditText teksedit= new EditText(this);
        teksedit.setInputType(3);
        Button converter=new Button(this);
        converter.setText("Converter");

        final TextView hasil = new TextView(this);


        converter.setId(1);
        teksedit.setId(2);
        label.setId(3);




        RelativeLayout myLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams viewParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        viewParams.addRule(RelativeLayout.ABOVE, teksedit.getId());
        viewParams.setMargins(0, 0, 0, 30);

        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.addRule(RelativeLayout.BELOW, teksedit.getId());
        buttonParams.setMargins(0, 0, 0, 0);

        RelativeLayout.LayoutParams hasilParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        hasilParams.addRule(RelativeLayout.BELOW, converter.getId());
        hasilParams.setMargins(0, 0, 0, 0);

        RelativeLayout.LayoutParams textParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.FILL_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        textParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textParams.setMargins(0, 0, 0, 10);

        //yang terakhir nih,, tambahkan kedua objek view yang kita buat sebelumnya

        converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText input=(EditText) findViewById(R.id.teksedit);


                String hasilnya=teksedit.getText().toString();
                int h=Integer.parseInt(hasilnya);
                double hitung=((1.8 * h)+32);
                String muncul=String.valueOf(hitung);
                hasil.setText(muncul+" F");

            }
        });

        myLayout.addView(label, viewParams);
        myLayout.addView(teksedit,textParams);
        myLayout.addView(converter,buttonParams);
        myLayout.addView(hasil,hasilParams);

        //set konten activity.
        setContentView(myLayout);
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

    public void buttonOnClick(View view){



    }


}
