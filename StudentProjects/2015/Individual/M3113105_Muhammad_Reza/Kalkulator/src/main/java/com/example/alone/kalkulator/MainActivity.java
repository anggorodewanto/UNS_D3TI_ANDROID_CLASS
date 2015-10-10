package com.example.alone.kalkulator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    TextView has;
    String operasi;
    EditText ang1,ang2;
    Spinner spin;
    Button but;
    String[] list = {"+","-","*","/"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ang1 = (EditText)findViewById(R.id.bil);
        ang2 = (EditText)findViewById(R.id.bil2);
        has = (TextView)findViewById(R.id.hasil);
        but = (Button)findViewById(R.id.plus);
        spin = (Spinner)findViewById(R.id.sp);
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                operasi = (list[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                operasi = (list[0]);
            }
        });
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operasi=="+") {
                    int angka1 = Integer.parseInt(ang1.getText().toString());
                    int angka2 = Integer.parseInt(ang2.getText().toString());

                    int total = angka1 + angka2;
                    has.setText(String.valueOf(total));
                }
                if(operasi=="-") {
                    int angka1 = Integer.parseInt(ang1.getText().toString());
                    int angka2 = Integer.parseInt(ang2.getText().toString());

                    int total = angka1 - angka2;
                    has.setText(String.valueOf(total));
                }
                if(operasi=="*") {
                    int angka1 = Integer.parseInt(ang1.getText().toString());
                    int angka2 = Integer.parseInt(ang2.getText().toString());

                    int total = angka1 * angka2;
                    has.setText(String.valueOf(total));
                }
                if(operasi=="/") {
                    int angka1 = Integer.parseInt(ang1.getText().toString());
                    int angka2 = Integer.parseInt(ang2.getText().toString());

                    int total = angka1 / angka2;
                    has.setText(String.valueOf(total));
                }
            }
        });
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,list);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spin.setAdapter(aa);
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
