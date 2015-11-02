package com.example.se7en.praktikum2_suhu;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        Button Button1 = new Button(this);
        Button1.setText("CONVERTER");

        final TextView myTextView = new TextView(this);
        myTextView.setText("Converter Celcius to Fahrenheit");

       final TextView myTextView2 = new TextView(this);
        myTextView2.setText("f");


       final EditText myEditText = new EditText(this);
        myEditText.setInputType(3);


        myTextView.setId(1);
        myTextView.setId(4);
        Button1.setId(2);
        myEditText.setId(3);

        RelativeLayout myLayout = new RelativeLayout(this);
        myLayout.setBackgroundColor(Color.CYAN);

        RelativeLayout.LayoutParams editTextParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.FILL_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        editTextParams.addRule(RelativeLayout.BELOW, myTextView.getId());

        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        buttonParams.addRule(RelativeLayout.BELOW, myEditText.getId());
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);


        RelativeLayout.LayoutParams Text2Params =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        Text2Params.addRule(RelativeLayout.BELOW, Button1.getId());

        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                final EditText t1 = (EditText)findViewById(myEditText.getId());
                final TextView output = (TextView)findViewById(myTextView2.getId());

                String nilai1 = t1.getText().toString();
                int a = Integer.parseInt(nilai1);
                double hasil = ((1.8*a)+32);
                String out = String.valueOf(hasil);
                myTextView2.setText(out+"F");

            }
        });
            myLayout.addView(myTextView);
            myLayout.addView(myEditText, editTextParams);
            myLayout.addView(Button1, buttonParams);
            myLayout.addView(myTextView2, Text2Params);
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
}

/*
 @Override
    public void onClick(View v) {
        awal = Double.parseDouble(edtInput.getText().toString());
        celcius = awal;
        fahrenheit = (1.8*awal)+32;
        edtCelcius.setText(String.valueOf(celcius));
        edtFahrenheit.setText(String.valueOf(fahrenheit));

    }

}

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Button myButton = new Button(this);

        myButton.setText("Press me");
        myButton.setBackgroundColor(Color.YELLOW);

        RelativeLayout myLayout = new RelativeLayout(this);

        myLayout.setBackgroundColor(Color.BLUE);

        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.addRule(RelativeLayout.CENTER_VERTICAL);

        myLayout.addView(myButton, buttonParams);
        setContentView(myLayout);
    }
}
  import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener {

    private EditText edtInput, edtCelcius, edtFahrenheit;
    double awal, celcius, fahrenheit;



   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       edtInput = (EditText) findViewById(R.id.editText1);
       edtCelcius = (EditText) findViewById(R.id.editText2);
       edtFahrenheit = (EditText) findViewById(R.id.editText3);
       this.proses = (Button) this.findViewById(R.id.proses);
       this.proses.setOnClickListener(this);

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

    public void  onClick(View v){
        awal = Double.parseDouble(edtInput.getText().toString());
        celcius = awal;
        fahrenheit = (1.8*awal)+32;
        edtCelcius.setText(String.valueOf(celcius));
        edtFahrenheit.setText(String.valueOf(fahrenheit));
    }*/







