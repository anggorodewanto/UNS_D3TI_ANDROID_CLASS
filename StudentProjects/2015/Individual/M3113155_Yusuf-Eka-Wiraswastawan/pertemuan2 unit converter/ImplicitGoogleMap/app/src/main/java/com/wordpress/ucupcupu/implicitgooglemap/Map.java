package com.wordpress.ucupcupu.implicitgooglemap;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Map extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        final EditText fieldalamat = (EditText) findViewById(R.id.alamat);
        final Button btncari = (Button) findViewById(R.id.cari);
        btncari.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    String alamat = fieldalamat.getText().toString();
                    alamat = alamat.replace('','+');
                    Intent geoIntent = new Intent (Intent.ACTION_VIEW,Uri.parse("geo:0,0?="+alamat));
                    startActivity(geoIntent);
                }
                catch (Exception e){

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_map, menu);
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
