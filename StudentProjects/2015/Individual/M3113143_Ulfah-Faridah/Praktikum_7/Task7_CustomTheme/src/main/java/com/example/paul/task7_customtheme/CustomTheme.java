package com.example.paul.task7_customtheme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by paul on 10/31/2015.
 */
public class CustomTheme extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custome_theme);

        Button btnback = (Button) findViewById(R.id.button1);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                startActivity(new Intent(CustomTheme.this, MainActivity.class));
                finish();
            }
        });
    }
}
