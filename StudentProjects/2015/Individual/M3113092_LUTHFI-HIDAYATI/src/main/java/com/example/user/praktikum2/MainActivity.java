package com.example.user.praktikum2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
		
		EditText teks;
        LinearLayout layout;
        Button button;
        TextView view;
		
		layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        teks=new EditText(this);
        teks.setHint("Masukkan suhu dalam celsius :");
        teks.setInputType(3);
        layout.addView(teks);
        button=new Button(this);
        button.setText("Hitung");
        layout.addView(button);
        teks.setId(R.id.editText);
		
		view=new TextView(this);
        layout.addView(view);
        view.setId(R.id.textView);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText teks =  (EditText)findViewById(R.id.editText);
                final TextView view =  (TextView)findViewById(R.id.textView);

                String value = teks.getText().toString();
                int i = Integer.parseInt(value);
                double hitung = ((1.8 * i) + 32);
                String out = String.valueOf(hitung);
                view.setText(out + " F");
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
