package com.nuriskandarz.praktikumsuhu_2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    EditText t1;
    TextView output;
    Button b;
    ScrollView sv;
    LinearLayout ll;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        sv = new ScrollView (this);
        ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        sv.addView(ll);

        t1=new EditText(this);
        ll.addView(t1);
        t1.setInputType(InputType.TYPE_CLASS_NUMBER);
        t1.setLayoutParams(new LinearLayout.LayoutParams(200, 50));


        b=new Button(this);
        b.setText("Convert to Fahrenheit");
        ll.addView(b);


        output=new TextView(this);
        ll.addView(output);
        this.setContentView(sv);

        b.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String value1 = t1.getText().toString();
                int c = Integer.parseInt(value1);
                int f = (c*9/5) + 32;
                String out = String.valueOf(f);
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
