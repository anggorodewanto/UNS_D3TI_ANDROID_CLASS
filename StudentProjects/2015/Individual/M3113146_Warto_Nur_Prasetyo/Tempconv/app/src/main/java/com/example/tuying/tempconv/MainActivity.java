package com.example.tuying.tempconv;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
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

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //create object
        final TextView label = new TextView(this);
        final EditText edit = new EditText(this);
        Button tombol = new Button(this);
        //set object
        tombol.setText("Click");
        tombol.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                float val = Float.parseFloat(edit.getText().toString());
                //    String hasil = String.Valueof(convert(val));

                label.setText(String.valueOf(convert(val)) + "°F");
            }
        });
        tombol.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
        label.setText("First Text");
        edit.setInputType(InputType.TYPE_CLASS_NUMBER);
        label.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
        edit.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
        //create layout
        LinearLayout frame= new LinearLayout(this);
        frame.setOrientation(LinearLayout.VERTICAL);
        frame.setGravity(Gravity.CENTER_HORIZONTAL);
        label.setGravity(Gravity.LEFT);
        frame.setLayoutParams(
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
        //add object to layout
        frame.addView(edit);
        frame.addView(tombol);
        frame.addView(label);

        //show layout
        setContentView(frame);
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

    public float convert(float value){
        float hasil;
        hasil=value*9/5 +32;
        return hasil;
    }
}
