package com.konversisuhu.praktikum2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtcelcius;
    private EditText celcius, fanren;
    private EditText edtfanren;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtcelcius= (EditText) findViewById(R.id.editText);
        edtfanren = (EditText) findViewById(R.id.editText);

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
    }edtfanren

    public void hitungsuhu (View vv){
        double n1 = double.parseDouble.(edtcelcius.getText().toString());
        celcius = n1;
        fanren = (1.8 * n1)+32;
        edtcelcius.setText(String.copyValueOf(celcius));
        edtfanren.setText(String.copyValueOf(fanren));



    }
}
