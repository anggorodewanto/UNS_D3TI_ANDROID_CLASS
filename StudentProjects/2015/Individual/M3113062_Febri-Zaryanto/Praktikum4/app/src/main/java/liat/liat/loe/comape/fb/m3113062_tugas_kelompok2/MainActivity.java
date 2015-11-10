package liat.liat.loe.comape.fb.m3113062_tugas_kelompok2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText input_panjang;
    public EditText input_lebar;
    public EditText hasil;
    public Button btnHitung;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input_panjang = (EditText) findViewById(R.id.input_panjang);
        input_lebar = (EditText) findViewById(R.id.input_lebar);
        hasil = (EditText) findViewById(R.id.hasil);
        btnHitung = (Button) findViewById(R.id.btnHitung);

        if(savedInstanceState == null){
            input_panjang.setText("");
            input_lebar.setText("");
            hasil.setText("");
        }
        else {
            Toast.makeText(this, "On Creating", Toast.LENGTH_LONG).show();
        }
    }

    public void hitungLuas(View view) {
        try {
            int panjang = Integer.parseInt(input_panjang.getText().toString());
            int lebar = Integer.parseInt(input_lebar.getText().toString());
            int luas = panjang * lebar;
            hasil.setText(String.valueOf(luas));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
        @Override
        protected void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
        }

        @Override
        protected void onRestoreInstanceState(Bundle savedInstanceState) {
            super.onRestoreInstanceState(savedInstanceState);
        }
    */
    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this, "On Starting", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(this, "On Resuming", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(this, "On Stoping", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(this, "On Destroying", Toast.LENGTH_LONG).show();
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

