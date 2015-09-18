package com.example.dulpi.unitconverter;

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
        Button myButton = new Button(this);
        myButton.setText("CONVERTER");

        final TextView myTextView = new TextView(this);
        myTextView.setText("Converter Celcius to Fahrenheit");

        final TextView myTextView2 = new TextView(this);
        //myTextView2.setText("f");


        final EditText myEditText = new EditText(this);
        myEditText.setInputType(3);


        myTextView.setId(1);
        myTextView2.setId(4);
        myButton.setId(2);
        myEditText.setId(3);

        RelativeLayout myLayout = new RelativeLayout(this);


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

        Text2Params.addRule(RelativeLayout.BELOW, myButton.getId());




        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText t1 = (EditText) findViewById(myEditText.getId());
                final TextView output = (TextView) findViewById(myTextView2.getId());

                String value1 = t1.getText().toString();
                int i = Integer.parseInt(value1);
                double d = ((1.8 * i) + 32);
                String out = String.valueOf(d);
                myTextView2.setText(out+" F");
            }
        });
        myLayout.addView(myTextView);
        myLayout.addView(myEditText, editTextParams);
        myLayout.addView(myButton, buttonParams);
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


