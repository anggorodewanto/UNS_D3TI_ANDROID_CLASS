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
        final EditText edittext = new EditText(this);
        LinearLayout ll = new LinearLayout(this);
        Button tombol = new Button(this);
        final TextView text = new TextView(this);
        text.setText("0");
        tombol.setText("Convert");
        edittext.setInputType(InputType.TYPE_CLASS_NUMBER);
        LinearLayout.LayoutParams dimensi =  new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams tomboldimensi =  new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams editdimensi =  new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams textdimensi =  new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        tomboldimensi.gravity= Gravity.CENTER;
        ll.setLayoutParams(dimensi);
        edittext.setLayoutParams(editdimensi);
        tombol.setLayoutParams(tomboldimensi);
        text.setLayoutParams(textdimensi);
        ll.setOrientation(LinearLayout.VERTICAL);
        tombol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float fahrenheit = Float.parseFloat(edittext.getText().toString());
                text.setText(String.valueOf(fahrenheit * 9/5 + 32)+" Fahrenheit");
            }
        });
        ll.addView(edittext);
        ll.addView(tombol);
        ll.addView(text);
        setContentView(ll);
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
