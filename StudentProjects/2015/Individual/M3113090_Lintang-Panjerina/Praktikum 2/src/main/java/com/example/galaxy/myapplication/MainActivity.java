package com.example.galaxy.myapplication;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
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

        EditText myEditText = new EditText(this);
        myEditText.setInputType(InputType.TYPE_CLASS_NUMBER);

        TextView myTextView = new TextView(this);
        myTextView.setText("Convert Celcius to Fahrenheit");

        TextView myHasil = new TextView(this);
        myHasil.setText("Hasil");

        myButton.setId(R.id.buttonid);
        myEditText.setId(R.id.textid);
        myTextView.setId(R.id.printid);
        myHasil.setId(4);

        RelativeLayout myLayout = new RelativeLayout(this);
        myLayout.setBackgroundColor(Color.WHITE);

        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        buttonParams.addRule(RelativeLayout.BELOW, myEditText.getId());
        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.setMargins(0, 0, 0, 25);

        RelativeLayout.LayoutParams textParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        textParams.addRule(RelativeLayout.BELOW, myTextView.getId());
        textParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textParams.setMargins(0, 0, 0, 20);

        RelativeLayout.LayoutParams textParams2 =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);


        textParams2.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textParams2.setMargins(0, 0, 0, 0);


        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, 200,
                r.getDisplayMetrics());

        myEditText.setWidth(px);

        myLayout.addView(myButton, buttonParams);
        myLayout.addView(myEditText, textParams);
        myLayout.addView(myTextView, textParams2);

        setContentView(myLayout);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText t1 = (EditText) findViewById(R.id .textid);
                final TextView output = (TextView) findViewById(R.id .printid);

                String value1 = t1.getText().toString();
                int i = Integer.parseInt(value1);
                double d = ((i * 9) / 5) + 32;
                String out = String.valueOf(d);
                output.setText(out);
            }
        });
    }
}


   /* @Override
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
    }*/

