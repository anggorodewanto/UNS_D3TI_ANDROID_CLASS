package stivan.tugasfragment;

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
        setContentView(R.layout.activity_main);

        LinearLayout layout1 = new LinearLayout(this);
        LinearLayout menu1 = new LinearLayout(this);
        LinearLayout fragment1 = new LinearLayout(this);

        final FrameLayout flayout = new FrameLayout(this);
        flayout.setId(122);
        layout1.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));

        final Start dataStart = new Start();
        final Identitas dataIdentitas = new Identitas();
        final Group dataGroup = new Group();

        Button start = new Button(this);
        Button identitas = new Button(this);
        Button group = new Button(this);

        start.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        start.setText("Start");

        identitas.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        identitas.setText("Identitas");

        group.setLayoutParams(new ActionBar.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        group.setText("Group");

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(flayout.getId(), dataStart, "Memulai Fragment");
                trans.commit();
            }
        });

        identitas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(flayout.getId(), dataIdentitas, "Identitas Saya");
                trans.commit();
            }
        });

        group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                trans.replace(flayout.getId(), dataGroup, "Nama Group");
                trans.commit();
            }
        });

        FragmentManager manager = getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.add(flayout.getId(),dataStart, "Selamat Datang");
        trans.commit();

        menu1.addView(start);
        menu1.addView(identitas);
        menu1.addView(group);

        fragment1.addView(flayout);

        layout1.addView(menu1);
        layout1.addView(fragment1);

        layout1.setOrientation(LinearLayout.VERTICAL);
        setContentView(layout1);



    }


}