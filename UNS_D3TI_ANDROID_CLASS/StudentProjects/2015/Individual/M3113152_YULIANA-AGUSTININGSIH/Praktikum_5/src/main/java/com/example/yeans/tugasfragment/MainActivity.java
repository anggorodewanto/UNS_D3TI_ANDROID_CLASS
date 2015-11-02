package com.example.yeans.tugasfragment;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView title = new TextView(this);
        Button buton1 = new Button(this);
        Button buton2 = new Button(this);
        Button buton3 = new Button(this);
        final TextView hasil = new TextView(this);

        title.setText("CHECK FRAGMENT");
        title.setTextSize(18);
        title.setGravity(Gravity.CENTER);
        buton1.setGravity(Gravity.CENTER);
        buton1.setText("Biodata");
        buton2.setGravity(Gravity.CENTER);
        buton2.setText("Cita-cita");
        buton3.setGravity(Gravity.CENTER);
        buton3.setText("About Me");
        hasil.setGravity(Gravity.CENTER);

        LinearLayout tampil = new LinearLayout(this);
        LinearLayout tampil2 = new LinearLayout(this);

        tampil.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        title.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        buton1.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        buton2.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        buton3.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        tampil.setOrientation(LinearLayout.VERTICAL);
        tampil.setGravity(Gravity.CENTER);
        tampil2.setOrientation(LinearLayout.HORIZONTAL);
        tampil2.setGravity(Gravity.CENTER);

        tampil.addView(title);
        tampil.addView(tampil2);
        tampil2.addView(buton1);
        tampil2.addView(buton2);
        tampil2.addView(buton3);
        tampil.addView(hasil);

        buton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasil.setText("Yuliana A");
            }
        });
        buton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasil.setText("Cepet Wisuda");
            }
        });
        buton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hasil.setText("M3113152");
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
