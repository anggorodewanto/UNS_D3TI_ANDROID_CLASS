package com.example.gita.conversisuhu;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EditText celsius;
        LinearLayout layout;
        Button buttonkonversi;
        TextView hasil;

        layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        celsius=new EditText(this);
        celsius.setHint("input celcius");

        RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT);

        textParams.addRule(RelativeLayout.ABOVE, celsius.getId());
        textParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        textParams.setMargins(0, 0, 0, 300);
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP, 300, r.getDisplayMetrics());
        celsius.setWidth(px);
        celsius.setInputType(3);
        layout.addView(celsius, textParams);

        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
        RelativeLayout.LayoutParams.WRAP_CONTENT,
        RelativeLayout.LayoutParams.WRAP_CONTENT);

        buttonParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonParams.setMargins(0, 0, 0, 300);
        buttonkonversi=new Button(this);
        buttonkonversi.setText("CONVERT");

        layout.addView(buttonkonversi, buttonParams);
        celsius.setId(R.id.editText1);

        hasil=new TextView(this);
        layout.addView(hasil);


        hasil.setId(R.id.text1);
        buttonkonversi.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO Auto-generated method stub
                final EditText t1 =  (EditText)findViewById(R.id.editText1);
                final TextView output =  (TextView)findViewById(R.id.text1);

                String value1 = t1.getText().toString();
                int i = Integer.parseInt(value1);
                double d = ((1.8 * i) + 32);
                String out = String.valueOf(d);
                output.setText(out +" F");
            }
        });
        setContentView(layout);
    }


}
