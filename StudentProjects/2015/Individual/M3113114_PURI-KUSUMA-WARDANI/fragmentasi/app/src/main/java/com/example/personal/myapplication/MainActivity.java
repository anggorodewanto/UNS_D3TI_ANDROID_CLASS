package com.example.personal.myapplication;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fm.beginTransaction();
        StartFragmen startFragment = new StartFragmen();

        transaction.add(R.id.fragment_placeholder, startFragment);
        transaction.commit();
    }

    public void onSelectFragment(View view){

        Fragment newFragment;

        if(view == findViewById(R.id.startFragment)){
            newFragment = new StartFragmen();
        } else if(view == findViewById(R.id.fragment1)){
            newFragment = new Fragmen1();
        } else if(view == findViewById(R.id.fragment2)){
            newFragment = new Fragmen2();
        } else if(view == findViewById(R.id.fragment3)){
            newFragment = new Fragmen3();
        } else{
            newFragment = new StartFragmen();
        }

        android.support.v4.app.FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_placeholder, newFragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}