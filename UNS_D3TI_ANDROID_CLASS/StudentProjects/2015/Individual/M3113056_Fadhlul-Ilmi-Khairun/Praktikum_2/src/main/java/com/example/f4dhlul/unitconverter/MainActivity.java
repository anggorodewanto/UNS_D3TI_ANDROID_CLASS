package com.example.f4dhlul.unitconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edit;
    LinearLayout layout;
    Button button;
    TextView output;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            layout=new LinearLayout(this);
            layout.setOrientation(LinearLayout.VERTICAL);
            edit=new EditText(this);
            edit.setHint("Enter celsius:");
            edit.setInputType(3);
            layout.addView(edit);
            button=new Button(this);
            button.setText("Convert");
            layout.addView(button);
            edit.setId(R.id.editText1);

            output=new TextView(this);
            layout.addView(output);
            output.setId(R.id.text1);

            button.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    // EditText t1;
                    // TextView output;
                    // TODO Auto-generated method stub
                    final EditText edit1 = (EditText) findViewById(R.id.editText1);
                    final TextView output = (TextView) findViewById(R.id.text1);

                    String value1 = edit1.getText().toString();
                    int i = Integer.parseInt(value1);
                    double fahrenheit = ((1.8 * i) + 32);
                    String out = String.valueOf(fahrenheit);
                    output.setText(out);
                }
            });

            setContentView(layout);
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
