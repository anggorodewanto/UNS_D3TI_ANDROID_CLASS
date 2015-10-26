package com.example.enggar.tugasmateridua_m3113054;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EditText editText1;
        EditText editText2;
        LinearLayout linear;
        Button b;
        TextView output;



        linear=new LinearLayout(this);
        linear.setOrientation(LinearLayout.VERTICAL);

        TextView myTextView = new TextView(this);
        myTextView.setText("Hitung Luas Persegi");
        myTextView.setId(1);
        linear.addView(myTextView);

        editText1=new EditText(this);
        editText1.setHint("Panjang");
        editText1.setInputType(3);
        linear.addView(editText1);

        editText2=new EditText(this);
        editText2.setHint("Lebar");
        editText2.setInputType(3);
        linear.addView(editText2);

        b=new Button(this);
        b.setText("Hitung");
        linear.addView(b);

        editText1.setId(R.id.editText1);
        editText2.setId(R.id.editText2);

        output=new TextView(this);
        linear.addView(output);
        //linear.setId(3);
        output.setId(R.id.text1);
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // EditText editText2;
                // TextView output;
                // TODO Auto-generated method stub
                final EditText editText2 =  (EditText)findViewById(R.id.editText2);
                final EditText editText1 =  (EditText)findViewById(R.id.editText1);
                final TextView output =  (TextView)findViewById(R.id.text1);

                String value1 = editText1.getText().toString();
                String value2 = editText2.getText().toString();
                int x = Integer.parseInt(value1);
                int y = Integer.parseInt(value2);
                double d = (x*y);
                String out = String.valueOf(d);
                output.setText(out + " " + "");
            }
        });
        setContentView(linear);
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

