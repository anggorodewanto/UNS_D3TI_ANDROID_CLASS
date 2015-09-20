package com.example.setiadidarmawan.converter;

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
        final TextView label = new TextView(this);
        final EditText editText = new EditText(this);
        Button button = new Button(this);

        //set text, gravitasi, dan ukuran
        label.setText("Hello World");
        label.setGravity(Gravity.START);
        label.setTextSize(20);


        editText.setInputType(InputType.TYPE_CLASS_NUMBER);

        button.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        button.setText("Convert!");

        //trus bikin layout yang akan menjadi root layout / viewgroups yg berisi view2
        LinearLayout layout = new LinearLayout(this);
            layout.setGravity(Gravity.CENTER_HORIZONTAL);

        //set layout root ini dengan width & height match_parent
        layout.setLayoutParams(new ViewGroup.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        //set orientasi vertical
        layout.setOrientation(LinearLayout.VERTICAL);

        //yang terakhir nih,, tambahkan kedua objek view yang kita buat sebelumnya
        layout.addView(editText);
        layout.addView(button);
        layout.addView(label);

        //set konten activity.
        setContentView(layout);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float f = Float.parseFloat(editText.getText().toString());
                label.setText(String.valueOf(convertCelciusToFahrenheit(f)) + "° F" );
            }

        });
    }

    // Converts to fahrenheit
    private float convertCelciusToFahrenheit(float celsius) {
        return ((celsius * 9) / 5) + 32;
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
