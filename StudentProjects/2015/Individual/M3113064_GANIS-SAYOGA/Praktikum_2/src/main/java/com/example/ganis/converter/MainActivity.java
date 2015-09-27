package com.example.ganis.converter;


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
        EditText t1;
        LinearLayout ll;
        Button b;
        TextView output;

        ll=new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        t1=new EditText(this);
        t1.setHint("Enter celsius:");
        t1.setInputType(3);
        ll.addView(t1);
        b=new Button(this);
        b.setText("Convert");
        ll.addView(b);
        t1.setId(R.id.editText1);

        output=new TextView(this);
        ll.addView(output);
        output.setId(R.id.text1);

        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                final EditText t1 =  (EditText)findViewById(R.id.editText1);
                final TextView output =  (TextView)findViewById(R.id.text1);

                String value1 = t1.getText().toString();
                int i = Integer.parseInt(value1);
                double d = ((1.8 * i) + 32);
                String out = String.valueOf(d);
                output.setText(out);
            }
        });
        setContentView(ll);
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
