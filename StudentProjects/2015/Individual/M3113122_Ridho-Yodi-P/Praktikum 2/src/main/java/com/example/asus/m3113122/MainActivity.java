package com.example.asus.m3113122;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        Button button = new Button(this);

        final EditText edittext = new EditText(this);
        final TextView viewtext = new TextView(this);

        viewtext.setText("0");
        button.setText("CONVERT");

        edittext.setInputType(InputType.TYPE_CLASS_NUMBER);

        LinearLayout.LayoutParams style =  new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        layout.setLayoutParams(style);

        LinearLayout.LayoutParams buttonstyle =  new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        button.setLayoutParams(buttonstyle);

        LinearLayout.LayoutParams editstyle =  new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        edittext.setLayoutParams(editstyle);

        LinearLayout.LayoutParams textstyle =  new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        viewtext.setLayoutParams(textstyle);

        buttonstyle.gravity= Gravity.CENTER;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float fahrenheit = Float.parseFloat(edittext.getText().toString());
                viewtext.setText(String.valueOf(fahrenheit * 9 / 5 + 32) + " Fahrenheit");
            }
        });

        layout.addView(edittext);
        layout.addView(button);
        layout.addView(viewtext);

        setContentView(layout);
        //setContentView(R.layout.activity_main);
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
