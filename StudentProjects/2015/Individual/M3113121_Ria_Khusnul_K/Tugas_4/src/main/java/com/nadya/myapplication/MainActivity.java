package com.nadya.myapplication;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        FrameLayout Flayout = new FrameLayout(this);
        Flayout.setId(123);
        layout.setLayoutParams(new ActionBar.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));


        FragmentManager manager = getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bio bio = new bio();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                FrameLayout Flayout = new FrameLayout(getApplicationContext());
                trans.replace(Flayout.getId(), bio, "biodata ni");
                trans.commit();
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View a) {
                cita cita = new cita();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                FrameLayout Flayout = new FrameLayout(getApplicationContext());
                trans.replace(Flayout.getId(), cita, "cita - cita");
                trans.commit();
            }

        });

        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View b) {
                about about = new about();
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                FrameLayout Flayout = new FrameLayout(getApplicationContext());
                trans.replace(Flayout.getId(), about, "about me");
                trans.commit();
            }

        });

        //trans.add(Flayout.getId(),frag,"apa lah");
        menu.addView(bio);
        menu.addView(cita);
        menu.addView(about);
        layout.addView(Flayout);
        setContentView(layout);
    }
}
