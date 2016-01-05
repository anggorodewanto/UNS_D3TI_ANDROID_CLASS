package com.example.yosica.prak5_fragmen;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


public class MainActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout = new LinearLayout(this);
        LinearLayout menu = new LinearLayout(this);
        LinearLayout fragmene = new LinearLayout(this);

        final FrameLayout flayout = new FrameLayout(this);
        flayout.setId(123);
        layout.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        final biodata databiodata = new biodata();
        final citacita datacitacita = new citacita();
        final aboutme dataaboutme = new aboutme();

        Button biodata = new Button(this);
        Button citacita = new Button(this);
        Button about = new Button(this);

        biodata.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        biodata.setText("Biodata");

        citacita.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        citacita.setText("Cita-Cita");

        about.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        about.setText("About Me");

        biodata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(flayout.getId(), databiodata, "apalah");
                trans.commit();
            }
        });

        citacita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(flayout.getId(), datacitacita, "apalah");
                trans.commit();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(flayout.getId(), dataaboutme, "apalah");
                trans.commit();
            }
        });

        FragmentManager manager = getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.add(flayout.getId(), databiodata, "apalah");//fragment default saat app dibuka
        trans.commit();

        //layout buat menu tombol
        menu.addView(biodata);
        menu.addView(citacita);
        menu.addView(about);

        //layout buat fragment layout
        fragmene.addView(flayout);

        //layout gabungan dari menu dan fragmen
        layout.addView(menu);
        layout.addView(fragmene);

        //set orientation layout gabungan
        layout.setOrientation(LinearLayout.VERTICAL);
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
