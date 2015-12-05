package com.example.hanifwidia.praktikum3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button runWebsite = (Button) findViewById(R.id.runWebsite);
        runWebsite.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText website = (EditText) findViewById(R.id.website);
                String strURL = website.getText().toString();
                if (strURL.indexOf("http://www") < 0) {
                    strURL = "http://www." + strURL;
                }
                Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(strURL));
                startActivity(implicit);
            }
        });
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
