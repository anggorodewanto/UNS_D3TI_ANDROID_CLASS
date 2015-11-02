package com.example.sholihun.prak2;

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
        Button myButton = new Button(this);
        myButton.setText("Convert");
        myButton.setBackgroundColor(Color.GRAY);

        RelativeLayout myLayout = new RelativeLayout(this);
        myLayout.setBackgroundColor(Color.GREEN);

        EditText myEditText = new EditText(this);

        TextView myTextDelok = new TextView(this);
        myTextDelok.setText("INI TEKS");

        myButton.setId(R.id.buttonid);
        myEditText.setId(R.id.textid);
        myEditText.setInputType(3);
        myTextDelok.setId(R.id.printid);

        RelativeLayout.LayoutParams buttonParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams textParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        RelativeLayout.LayoutParams textviewParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);

        textParams.addRule(RelativeLayout.ABOVE, myButton.getId());
        textParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textParams.setMargins(0, 0, 0, 80);

        textviewParams.addRule(RelativeLayout.BELOW, myButton.getId());
        textviewParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textviewParams.setMargins(0, 50, 0, 80);

        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.addRule(RelativeLayout.CENTER_VERTICAL);

        myLayout.addView(myButton, buttonParams);
        myLayout.addView(myEditText, textParams);
        myLayout.addView(myTextDelok, textviewParams);
        setContentView(myLayout);
        //setContentView(R.layout.activity_main);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText t1;
                // TextView output;
                // TODO Auto-generated method stub
                final EditText t1 = (EditText) findViewById(R.id.textid);
                final TextView output = (TextView) findViewById(R.id.printid);

                String value1 = t1.getText().toString();
                int i = Integer.parseInt(value1);
                double d = ((i * 9) / 5) + 32;
                String out = String.valueOf(d);
                output.setText(out);
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