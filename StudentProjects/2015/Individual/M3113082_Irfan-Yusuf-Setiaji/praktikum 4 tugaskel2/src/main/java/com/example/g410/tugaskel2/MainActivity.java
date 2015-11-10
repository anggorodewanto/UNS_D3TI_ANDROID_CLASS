package com.example.g410.tugaskel2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editPanjang;
    private EditText editLebar;
    private EditText editLuas;
    private Button butonHitungLuas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initEvent();
    }

    private void initUI(){
        editPanjang = (EditText) findViewById(R.id.editTextPanjang);
        editLebar = (EditText) findViewById(R.id.editTextLebar);
        editLuas = (EditText) findViewById(R.id.editTextLuas);
        butonHitungLuas = (Button) findViewById(R.id.buttonHitungLuas);
    }

    private void initEvent(){
        butonHitungLuas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungLuas();
            }
        });
    }
    private void hitungLuas(){
        int panjang = Integer.parseInt(editPanjang.getText().toString());
        int lebar = Integer.parseInt(editLebar.getText().toString());
        int luas = panjang*lebar;
        editLuas.setText(luas + "");
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
