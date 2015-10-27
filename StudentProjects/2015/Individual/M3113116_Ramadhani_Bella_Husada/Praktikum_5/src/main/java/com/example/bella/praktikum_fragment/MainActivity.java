package com.example.bella.praktikum_fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;

public class MainActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
        StartFragment startFragment = new StartFragment();

        transaction.add(R.id.fragment_placeholder, startFragment);
        transaction.commit();
    }

    public void onSelectFragment(View view){

        Fragment newFragment;

        if(view == findViewById(R.id.startFragment)){
            newFragment = new StartFragment();
        } else if(view == findViewById(R.id.fragment1)){
            newFragment = new Fragment1();
        } else if(view == findViewById(R.id.fragment2)){
            newFragment = new Fragment2();
        } else if(view == findViewById(R.id.fragment3)){
            newFragment = new Fragment3();
        } else{
            newFragment = new StartFragment();
        }

        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_placeholder, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}