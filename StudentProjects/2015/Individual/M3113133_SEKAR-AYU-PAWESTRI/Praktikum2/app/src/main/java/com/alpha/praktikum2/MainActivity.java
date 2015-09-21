package com.alpha.praktikum2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.Gravity;
import android.app.ActionBar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView t1 = new TextView(this);
        final TextView t2 = new TextView(this);
        final EditText e1 = new EditText(this);
        Button b1 = new Button(this);
        b1.setGravity(Gravity.CENTER);
        e1.setGravity(Gravity.CENTER);
        t1.setText("Konversi Celcius to Fahrenheit");
        b1.setText("Hitung");
        LinearLayout layoutnya = new LinearLayout(this);

        layoutnya.setLayoutParams(new ActionBar.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        e1.setLayoutParams(new ActionBar.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        t1.setLayoutParams(new ActionBar.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        b1.setLayoutParams(new ActionBar.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        layoutnya.setOrientation(LinearLayout.VERTICAL);
        layoutnya.setGravity(Gravity.CENTER);

        layoutnya.addView(t1);
        layoutnya.addView(e1);
        layoutnya.addView(t2);
        layoutnya.addView(b1);

        b1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                float nilai = Float.parseFloat(e1.getText().toString());
                t2.setText(String.valueOf(nilai*9/5+32)+" F");
            }

        });

        setContentView(layoutnya);

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