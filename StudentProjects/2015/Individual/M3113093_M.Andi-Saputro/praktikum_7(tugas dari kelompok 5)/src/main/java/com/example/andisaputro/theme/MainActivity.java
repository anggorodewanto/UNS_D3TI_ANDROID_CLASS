package com.example.andisaputro.theme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.content.Intent;
import android.app.TabActivity;

public class MainActivity extends AppCompatActivity {
    TabHost tabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();
        Intent intent;

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("PANGGILAN");
        spec.setContent(R.id.tab1);
        spec.setIndicator("PANGGILAN");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("CHATTING");
        spec.setContent(R.id.tab2);
        spec.setIndicator("CHATTING");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("KONTAK");
        spec.setContent(R.id.tab3);
        spec.setIndicator("KONTAK");
        host.addTab(spec);
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