package com.nuriskandarz.praktikum_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    EditText temp;
    RadioButton toC;
    RadioButton toF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        temp = (EditText)findViewById(R.id.temperatureEditText);
        toC = (RadioButton)findViewById(R.id.toCelciusRadioButton);
        toF = (RadioButton)findViewById(R.id.toFahrenheitRadioButton);

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

    public void convert(View v){
        double value = new Double(temp.getText().toString());
        if (toC.isChecked())
            value = UnitConverter.fahrenheit2Celcius(value);
                    else
            value = UnitConverter.celcius2Fahrenheit(value);
        temp.setText(new Double(value).toString());


    }
}
