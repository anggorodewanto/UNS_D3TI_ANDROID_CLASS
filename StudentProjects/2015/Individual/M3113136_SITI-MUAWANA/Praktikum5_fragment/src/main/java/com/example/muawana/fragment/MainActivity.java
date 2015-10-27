package com.example.muawana.fragment;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

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
        final biodata fragbiodata = new biodata();
        final citacita fragcitacita = new citacita();
        final aboutme fragaboutme = new aboutme();

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
                trans.replace(flayout.getId(), fragbiodata, "apalah");
                trans.commit();
            }
        });

        citacita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(flayout.getId(), fragcitacita, "apalah");
                trans.commit();
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(flayout.getId(), fragaboutme, "apalah");
                trans.commit();
            }
        });

        FragmentManager manager = getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.add(flayout.getId(), fragbiodata, "apalah");//fragment default saat app dibuka
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

}
