package com.example.alamin.praktikum;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;
import android.graphics.Color;
import android.widget.EditText;
import android.content.res.Resources;
import android.util.TypedValue;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EditText awal;
        Button convert;
        TextView hasil,hasil1;



        RelativeLayout mylayout = new RelativeLayout(this);
        mylayout.setBackgroundColor(Color.WHITE);



        awal=new EditText(this);
        awal.setHint("Masukkan celsius:");
        awal.setInputType(3);


        convert=new Button(this);
        convert.setText("Convert");

        RelativeLayout.LayoutParams textParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        textParams.addRule(RelativeLayout.ABOVE, convert.getId());
        textParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textParams.setMargins(0, 0, 0, 20);

        RelativeLayout.LayoutParams HasParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        HasParams.addRule(RelativeLayout.ABOVE, convert.getId());
        HasParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        HasParams.setMargins(0, 40, 0, 20);

        RelativeLayout.LayoutParams HasilParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        HasilParams.addRule(RelativeLayout.ABOVE, convert.getId());
        HasilParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        HasilParams.setMargins(0, 60, 0, 20);

        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.setMargins(0, 100, 0, 0);

        mylayout.addView(awal, textParams);
        mylayout.addView(convert,buttonParams);

        hasil1=new TextView(this);
        hasil1.setText("Fahreinhait");
        mylayout.addView(hasil1, HasParams);

        awal.setId(R.id.editText1);
        hasil=new TextView(this);
        mylayout.addView(hasil,HasilParams);
        hasil.setId(R.id.text1);


        convert.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                final EditText t1 =  (EditText)findViewById(R.id.editText1);
                final TextView hasil =  (TextView)findViewById(R.id.text1);

                String value1 = t1.getText().toString();
                int i = Integer.parseInt(value1);
                double d = ((1.8 * i) + 32);
                String hasil1 = String.valueOf(d);
                hasil.setText(hasil1);
            }
        });
        setContentView(mylayout);
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