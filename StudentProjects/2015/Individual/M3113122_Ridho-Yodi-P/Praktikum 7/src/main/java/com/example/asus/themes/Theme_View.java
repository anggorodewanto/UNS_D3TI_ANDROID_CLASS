package com.example.asus.themes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by asus on 31/10/2015.
 */
public class Theme_View extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme);

        Button btnback = (Button) findViewById(R.id.button);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(Theme_View.this, MainActivity.class));
                finish();
            }
        });
    }
}
