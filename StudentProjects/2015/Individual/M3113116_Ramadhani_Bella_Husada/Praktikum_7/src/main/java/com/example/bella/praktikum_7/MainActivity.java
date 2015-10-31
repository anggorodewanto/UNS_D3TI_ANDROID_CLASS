package com.example.bella.praktikum_7;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity {

    Button next_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        next_button = (Button) findViewById(R.id.button);
        next_button.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                // TODO Auto-generated method stub
                Intent implicit_intent = new Intent(MainActivity.this,
                        Next_Activity.class);
                startActivity(implicit_intent);

            }

        });
    }

}
