package com.example.se7en.praktikum4_k2_lifecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"Sedang On Create", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart(){
        super.onStart();
        Toast.makeText(this,"Sedang on Start", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onResume(){
        super.onResume();
        Toast.makeText(this,"Sedang on Resume", Toast.LENGTH_LONG).show();

    }


    @Override
    public void onPause(){
        super.onPause();
        Toast.makeText(this,"Sedang on Pause", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onStop(){
        super.onStop();
        Toast.makeText(this,"Sedang On Stop", Toast.LENGTH_LONG).show();

    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Toast.makeText(this,"Sedang on Destroy", Toast.LENGTH_LONG).show();

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
