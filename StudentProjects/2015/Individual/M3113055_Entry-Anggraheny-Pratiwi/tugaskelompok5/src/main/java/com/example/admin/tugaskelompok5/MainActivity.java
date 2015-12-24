package com.example.admin.tugaskelompok5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        TabHost.TabSpec spec = host.newTabSpec("Call");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Call");
        host.addTab(spec);

        
        spec = host.newTabSpec("Chat");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Chat");
        host.addTab(spec);

    
        spec = host.newTabSpec("Contak");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Contact");
        host.addTab(spec);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
         int id = item.getItemId();

       if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}