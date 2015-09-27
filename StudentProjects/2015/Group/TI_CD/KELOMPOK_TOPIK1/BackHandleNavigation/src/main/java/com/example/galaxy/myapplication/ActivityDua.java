package com.example.galaxy.myapplication;

/**
 * Created by GALAXY on 18/09/2015.
 */

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;


public class ActivityDua extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitydua);

        Button btnback = (Button) findViewById(R.id.button1);

        btnback.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(ActivityDua.this, MainActivity.class));
                finish();

            }
        });


    }


}
