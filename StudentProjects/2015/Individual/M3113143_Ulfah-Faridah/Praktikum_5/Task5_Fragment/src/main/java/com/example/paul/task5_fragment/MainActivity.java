package com.example.paul.task5_fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    FragmentManager fragmentManager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();

        biodata a = new biodata();
        transaction.add(R.id.frame, a);
        transaction.commit();
    }

    public void biodata (View view)
    {
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();

        biodata a = new biodata();
        transaction.replace(R.id.frame, a);
        transaction.commit();
    }

    public void citacita(View view)
    {
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();

        citacita b = new citacita();
        transaction.replace(R.id.frame, b);
        transaction.commit();
    }

    public void about(View view)
    {
        fragmentManager = getFragmentManager();
        transaction = fragmentManager.beginTransaction();

        about c = new about();
        transaction.replace(R.id.frame, c);
        transaction.commit();
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
