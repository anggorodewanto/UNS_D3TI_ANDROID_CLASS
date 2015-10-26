package com.example.win7.tugaskel2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtPanjang;
    private EditText edtLebar;
    private EditText edtLuas;
    private Button btnHitungLuas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initEvent();
    }
    private void initUI(){
        edtPanjang = (EditText) findViewById(R.id.editTextPanjang);
        edtLebar = (EditText) findViewById(R.id.editTextLebar);
        edtLuas = (EditText) findViewById(R.id.editTextLuas);
        btnHitungLuas = (Button) findViewById(R.id.buttonHitungLuas);
    }
    private void initEvent(){
        btnHitungLuas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungLuas();
            }
        });
    }
    private void hitungLuas(){
        int panjang = Integer.parseInt(edtPanjang.getText().toString());
        int lebar = Integer.parseInt(edtLebar.getText().toString());
        int luas = panjang*lebar;
        edtLuas.setText(luas+"");
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
