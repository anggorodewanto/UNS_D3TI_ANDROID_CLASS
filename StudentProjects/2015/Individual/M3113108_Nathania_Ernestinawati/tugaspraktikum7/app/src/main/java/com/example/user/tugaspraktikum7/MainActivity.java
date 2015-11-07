package com.example.user.tugaspraktikum7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClickSatu(View view){

        Intent intent = new Intent (this, com.example.user.tugaspraktikum7.ActivitySatu.class);
        startActivity(intent);

    }


}