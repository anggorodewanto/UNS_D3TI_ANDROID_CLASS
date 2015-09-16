package com.example.hp.praktikum2;
/*
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myButton = Button(this);
        myButton.setText("Convert");
        TextView mytext = TextView(this);
        mytext.setText("Convert Celcius to Fahrenheit");

        RelativeLayout myLayout = new RelativeLayout(this);
        myLayout.addView(myButton);
        myLayout.addView(mytext);
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
*/

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Button myButton = new Button(this);
        myButton.setText("CONVERT");
        final EditText myEditText = new EditText(this);
        myEditText.setInputType(3);
        TextView myText = new TextView(this);
        myText.setText("Convert Celcius to Fahrenheit");
        final TextView myText2 = new TextView(this);

        myButton.setId(1);
        myEditText.setId(2);
        myText.setId(3);
        myText2.setId(4);

        RelativeLayout myLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams textParams1=
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );

        textParams1.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textParams1.setMargins(0, 0, 0, 50);

        RelativeLayout.LayoutParams textParams2=
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT
                );
        textParams2.addRule(RelativeLayout.BELOW,myButton.getId());
        textParams2.setMargins(0, 0, 0, 0);

        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        buttonParams.addRule(RelativeLayout.BELOW,myEditText.getId());

        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.setMargins(0, 0, 0, 0);

        RelativeLayout.LayoutParams textParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.FILL_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        textParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textParams.addRule(RelativeLayout.BELOW,myText.getId());
        textParams.setMargins(0, 0, 0,0);

        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 200,
                r.getDisplayMetrics());

        myEditText.setWidth(px);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText t1;
                // TextView output;
                // TODO Auto-generated method stub
                final EditText t1 = (EditText) findViewById(R.id.myEditText);
                final TextView output = (TextView) findViewById(R.id.myText);

                String value1 = myEditText.getText().toString();
                int i = Integer.parseInt(value1);
                double d = ((1.8 * i) + 32);
                String out = String.valueOf(d);
                myText2.setText(out+"F");
            }
        });

        myLayout.addView(myButton, buttonParams);
        myLayout.addView(myEditText, textParams);
        myLayout.addView(myText, textParams1);
        myLayout.addView(myText2, textParams2);
        setContentView(myLayout);
    }

    public void onButtonClick(View view){



    }
}