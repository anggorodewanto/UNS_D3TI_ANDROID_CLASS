package com.example.tuying.fragment;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

@SuppressWarnings("ALL")
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout layout1=new LinearLayout(this);
        LinearLayout layout2=new LinearLayout(this);
        LinearLayout layout3=new LinearLayout(this);
        Button b1=new Button(this);
        Button b2=new Button(this);
        Button b3=new Button(this);
        final FrameLayout flayout=new FrameLayout(this);
        final FragmentManager man = getFragmentManager();
        final FragmentTransaction trans = man.beginTransaction();
        final ContohFragment frag1= new ContohFragment();
        flayout.setId(123);
        b1.setText("1");
        b2.setText("2");
        b3.setText("3");
        trans.add(flayout.getId(), frag1);
        trans.commit();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(123, frag1);
                transaction.commit();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContohFragment2 frag2 = new ContohFragment2();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(123, frag2);
                transaction.commit();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContohFragment3 frag3 = new ContohFragment3();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(123, frag3);
                transaction.commit();

            }
        });
        layout1.setGravity(Gravity.CENTER_HORIZONTAL);
        layout1.setLayoutParams(
                new ActionBar.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));


        layout1.setOrientation(LinearLayout.VERTICAL);
        layout2.addView(b1);
        layout2.addView(b2);
        layout2.addView(b3);
        layout3.addView(flayout);
        layout1.addView(layout2);
        layout1.addView(layout3);
        setContentView(layout1);
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
